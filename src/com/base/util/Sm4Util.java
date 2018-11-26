package com.base.util;
/**
 * SM4�㷨�����߾�������Ʒʹ�õ� SMS4 �����㷨 <br>
 * ���㷨��һ�������㷨�����㷨�ķ��鳤��Ϊ 128 ���أ���Կ����Ϊ 128 ���ء�����<br>
 * �㷨����Կ��չ�㷨������ 32 �ַ����Ե����ṹ�������㷨������㷨�Ľṹ��ͬ��<br>
 * ֻ������Կ��ʹ��˳���෴����������Կ�Ǽ�������Կ������<br>
 * 
 * <code>
 * 1 ����˵��
 * 1.1  �����ֽ� 
 *   ��Z(2^e)��ʾ e-���ص���������Z(2^32)�е�Ԫ�س�Ϊ�֣�Z(2^8)�е�Ԫ�س�Ϊ�ֽڡ� 
 * 1.2  S�� 
 *   S ��Ϊ�̶��� 8 �������� 8 ����������û�����Ϊ Sbox(.)�� 
 * 1.3  �������� 
 * �ڱ��㷨�в��������»������㣺 
 *   ��        32������� 
 *   <<<i   32 ����ѭ������ i λ 
 * 1.4  ��Կ����Կ���� 
 *   ������Կ����Ϊ 128 ���أ���ʾΪMK=(MK[0], MK[1], MK[2], MK[3])������MK[i](i=0,1,2,3)Ϊ�֡� 
 *   ����Կ��ʾΪ(rk0, rk1, ��, rk31)������rk[i](i=0,��,31)Ϊ�֡�����Կ�ɼ�����Կ���ɡ� 
 *   FK=(FK[0], FK[1], FK[2], FK[3])Ϊϵͳ������CK=(CK[0], CK[1],��, CK[31])Ϊ�̶�������������Կ��
 *   չ�㷨������FKi(i=0,��,3)��CKi(i=0,��,31)Ϊ�֡� 
 *   
 * </code>
 * 
 * @author xujun
 * 
 */
public class Sm4Util {

	/**
	 * �������� ����ѭ������
	 * 
	 * @param value
	 * @param k
	 * @return
	 */
	private static int cycleLeftShift(int value, int k) {
		// ����������32λ������ʵ��32λ�����������ƶ��ޱ仯���ɺ���
		int realShift = k % 32;
		if (realShift == 0) {
			return value;
		} else {
			// �ȵõ����Ƶ�����
			int t1 = value << realShift;
			// �޷������ƣ����ʼ�ղ���
			int t2 = value >>> (32 - realShift);
			int t = t1 | t2;
			return t;
		}
	}

	/**
	 * �������� ����������ֽ�����ת��
	 * 
	 * @param n
	 * @return
	 */
	private static byte[] int2bytes(int n) {
		byte[] ab = new byte[4];
		ab[3] = (byte) (0xff & n);
		ab[2] = (byte) ((0xff00 & n) >> 8);
		ab[1] = (byte) ((0xff0000 & n) >> 16);
		ab[0] = (byte) ((0xff000000 & n) >> 24);
		return ab;
	}

	/**
	 * �������� �����������ֽ�����
	 * 
	 * @param n
	 * @return
	 */
	private static void int2bytes(byte[] ab, int n, int position) {
		ab[position + 3] = (byte) (0xff & n);
		ab[position + 2] = (byte) ((0xff00 & n) >> 8);
		ab[position + 1] = (byte) ((0xff0000 & n) >> 16);
		ab[position + 0] = (byte) ((0xff000000 & n) >> 24);
	}

	/**
	 * �������� ����ֽ����鵽������ת��
	 * 
	 * @param b
	 * @return
	 */
	private static int bytes2int(byte b[]) {
		return bytes2int(b, 0);
	}

	/**
	 * �������� ����ֽ����鵽������ת��
	 * 
	 * @param b
	 * @return
	 */
	private static int bytes2int(byte b[], int startPostion) {
		int s = 0;
		s = ((((b[startPostion] & 0xff) << 8 | (b[startPostion + 1] & 0xff)) << 8) | (b[startPostion + 2] & 0xff)) << 8
				| (b[startPostion + 3] & 0xff);
		return s;
	}

	/**
	 * ��SboxTable��Ѱ�Ҷ�Ӧ��ֵ
	 * 
	 * @param in
	 *            0x00~0xFF (8 bits unsigned value).
	 * @return
	 */
	private static int sm4Sbox(byte in) {
		int y = 0xf & in;
		int x = (0xf0 & in) >> 4;
		return SboxTable[x][y];
	}

	/**
	 * <code>
	 * 2.1  �ϳ��û� T  
	 *     private F(Lt) function: 
	 *     T��Z(2^32) �� Z(2^32)����һ������任���ɷ����Ա任 �� �����Ա任 L ���϶���,�� T(.)=L(��(.))��  
	 *     "T algorithm" == "L algorithm" + "t algorithm".
	 * 2.1.1 �����Ա任�� 
	 *      �� �� 4 �����е� S�й��ɡ� 
	 *      ������Ϊ A=(a0,a1,a2,a3)��(Z(2^32))^4, ���ΪB=(b0,b1,b2,b3)��(Z(2^32))^4 ,��
	 *      B=(b0,b1,b2,b3) = �� (A) = (SBox(a0), SBox(a1), SBox(a2), SBox(a3))
	 * 2.1.2 ���Ա任 L 
	 *      �����Ա任 �� ����������Ա任 L �����롣������ΪB��(Z(2^32))^4 �����ΪC��(Z(2^32))^4 ����
	 *      C = L (B) =B �� ( B <<<2 ) �� ( B <<<10 ) �� ( B <<<18 ) �� ( B <<<24 )
	 * </code>
	 * 
	 * @param A
	 *            is a 32 bits unsigned value;
	 * @return is calculated
	 */
	private static int sm4Lt(int A) {
		byte[] a = int2bytes(A);
		byte[] b = new byte[4];
		b[0] = (byte) sm4Sbox(a[0]);
		b[1] = (byte) sm4Sbox(a[1]);
		b[2] = (byte) sm4Sbox(a[2]);
		b[3] = (byte) sm4Sbox(a[3]);
		int B = bytes2int(b);
		int C = B ^ cycleLeftShift(B, 2) ^ cycleLeftShift(B, 10)
				^ cycleLeftShift(B, 18) ^ cycleLeftShift(B, 24);
		return C;
	}

	/**
	 * 2.2 S��
	 * 
	 * S �������ݾ����� 16 ���Ʊ�ʾ��������Ϊ16��(0~f)��16��(0~f)<br>
	 * Expanded SM4 S-boxes <br>
	 * Sbox table: 8bits input convert to 8 bits output �������롮ef������ S �к��ֵΪ���е� e
	 * �к͵� f�е�ֵ��Sbox(��ef��)= ��84����
	 */
	private static int[][] SboxTable = {
			{ 0xd6, 0x90, 0xe9, 0xfe, 0xcc, 0xe1, 0x3d, 0xb7, 0x16, 0xb6, 0x14,
					0xc2, 0x28, 0xfb, 0x2c, 0x05 },
			{ 0x2b, 0x67, 0x9a, 0x76, 0x2a, 0xbe, 0x04, 0xc3, 0xaa, 0x44, 0x13,
					0x26, 0x49, 0x86, 0x06, 0x99 },
			{ 0x9c, 0x42, 0x50, 0xf4, 0x91, 0xef, 0x98, 0x7a, 0x33, 0x54, 0x0b,
					0x43, 0xed, 0xcf, 0xac, 0x62 },
			{ 0xe4, 0xb3, 0x1c, 0xa9, 0xc9, 0x08, 0xe8, 0x95, 0x80, 0xdf, 0x94,
					0xfa, 0x75, 0x8f, 0x3f, 0xa6 },
			{ 0x47, 0x07, 0xa7, 0xfc, 0xf3, 0x73, 0x17, 0xba, 0x83, 0x59, 0x3c,
					0x19, 0xe6, 0x85, 0x4f, 0xa8 },
			{ 0x68, 0x6b, 0x81, 0xb2, 0x71, 0x64, 0xda, 0x8b, 0xf8, 0xeb, 0x0f,
					0x4b, 0x70, 0x56, 0x9d, 0x35 },
			{ 0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, 0xd1, 0xa2, 0x25, 0x22, 0x7c,
					0x3b, 0x01, 0x21, 0x78, 0x87 },
			{ 0xd4, 0x00, 0x46, 0x57, 0x9f, 0xd3, 0x27, 0x52, 0x4c, 0x36, 0x02,
					0xe7, 0xa0, 0xc4, 0xc8, 0x9e },
			{ 0xea, 0xbf, 0x8a, 0xd2, 0x40, 0xc7, 0x38, 0xb5, 0xa3, 0xf7, 0xf2,
					0xce, 0xf9, 0x61, 0x15, 0xa1 },
			{ 0xe0, 0xae, 0x5d, 0xa4, 0x9b, 0x34, 0x1a, 0x55, 0xad, 0x93, 0x32,
					0x30, 0xf5, 0x8c, 0xb1, 0xe3 },
			{ 0x1d, 0xf6, 0xe2, 0x2e, 0x82, 0x66, 0xca, 0x60, 0xc0, 0x29, 0x23,
					0xab, 0x0d, 0x53, 0x4e, 0x6f },
			{ 0xd5, 0xdb, 0x37, 0x45, 0xde, 0xfd, 0x8e, 0x2f, 0x03, 0xff, 0x6a,
					0x72, 0x6d, 0x6c, 0x5b, 0x51 },
			{ 0x8d, 0x1b, 0xaf, 0x92, 0xbb, 0xdd, 0xbc, 0x7f, 0x11, 0xd9, 0x5c,
					0x41, 0x1f, 0x10, 0x5a, 0xd8 },
			{ 0x0a, 0xc1, 0x31, 0x88, 0xa5, 0xcd, 0x7b, 0xbd, 0x2d, 0x74, 0xd0,
					0x12, 0xb8, 0xe5, 0xb4, 0xb0 },
			{ 0x89, 0x69, 0x97, 0x4a, 0x0c, 0x96, 0x77, 0x7e, 0x65, 0xb9, 0xf1,
					0x09, 0xc5, 0x6e, 0xc6, 0x84 },
			{ 0x18, 0xf0, 0x7d, 0xec, 0x3a, 0xdc, 0x4d, 0x20, 0x79, 0xee, 0x5f,
					0x3e, 0xd7, 0xcb, 0x39, 0x48 } };

	/**
	 * 3. ��/�����㷨 <code>
	 * 
	 * ���巴��任 R Ϊ�� 
	 * R ( A[0], A[1], A[2], A[3]) =   ( A[3], A[2], A[1], A[0])
	 * ����A[i]��Z(2^32), i=0,1,2,3
	 * ����������Ϊ ( X[0], X[1], X[2], X[3]) �� Z(2^32)��
	 * �������Ϊ(  Y[0], Y[1], Y[2], Y[3]) �� Z(2^32)��
	 * ����ԿΪrk[i] �� Z(2^32)��i=0,1,2,3....31��
	 * ���㷨�ļ��ܱ任Ϊ��
	 * X[i+4] = F ( X[i], X[i+1], X[i+2], X[i+3], rk[i]) =  X[i] �� T (X[i+1] �� X[i+2] �� X[i+3] �� rk[i]), i=0,1,2,....31
	 * ( Y[0], Y[1], Y[2], Y[3]) = R ( X[32], X[33], X[34], X[35]) =  ( X[35], X[34], X[33], X[32])
	 * 
	 * ���㷨�Ľ��ܱ任����ܱ任�ṹ��ͬ����ͬ�Ľ�������Կ��ʹ��˳��  
	 * ����ʱ����Կ��ʹ��˳��Ϊ����rk0, rk1, ��, rk31��   
	 * ����ʱ����Կ��ʹ��˳��Ϊ����rk31, rk30, ��, rk0�� 
	 * </code>
	 * 
	 * @param x0
	 * @param x1
	 * @param x2
	 * @param x3
	 * @param rk
	 * @return
	 */
	private static int sm4F(int x0, int x1, int x2, int x3, int rk) {
		return (x0 ^ sm4Lt(x1 ^ x2 ^ x3 ^ rk));
	}

	/**
	 * 4. ��Կ��չ�㷨 <code>
	 * ���㷨�м����㷨������Կ�ɼ�����Կͨ����Կ��չ�㷨���ɡ� 
	 * ������ԿMK=(MK[0], MK[1], MK[2], MK[3])��MK[i] �� Z(2^32) ��i��0,1,2,3�� 
	 * ��Ki �� Z(2^32)��i��0,1,��,35������ԿΪ rk[i] �� Z(2^32)��������Կ���ɷ���Ϊ��
	 *      ���ȣ�(K[0], K[1], K[2], K[3])=(MK[0] �� FK[0], MK[1] �� FK[1], MK[2] �� FK[2], MK[3] �� FK[3]) 
	 *      Ȼ�󣬶� �� i��0,1,��,31 :
	 *      rk[i] = K[i+4] = K[i] �� T' (K[i+1] �� K[i+2] �� K[i+3] �� CK[i] )
	 * ˵��
	 * ��1�� T'�任������㷨�ֺ����е�T������ͬ��ֻ�����е����Ա任L�޸�Ϊ���� �� 
	 *       L' (B) =B �� ( B <<<13 ) �� ( B <<<23 )  
	 * </code>
	 * 
	 * @param
	 * @return
	 */
	private static int sm4CalciRK(int K) {
		byte[] a = int2bytes(K);
		byte[] b = new byte[4];
		b[0] = (byte) sm4Sbox(a[0]);
		b[1] = (byte) sm4Sbox(a[1]);
		b[2] = (byte) sm4Sbox(a[2]);
		b[3] = (byte) sm4Sbox(a[3]);
		int B = bytes2int(b);
		int rk = B ^ (cycleLeftShift(B, 13)) ^ (cycleLeftShift(B, 23));
		return rk;
	}

	/**
	 * <code>
	 * ��2��ϵͳ���� FK��ȡֵ������ 16 ���Ʊ�ʾΪ�� 
	 * FK0=(A3B1BAC6)��FK1=(56AA3350)��FK2=(677D9197)��FK3=(B27022DC) 
	 *  </code>
	 */
	private static int[] FK = { 0xa3b1bac6, 0x56aa3350, 0x677d9197, 0xb27022dc };

	/**
	 * <code>
	 * ��3���̶����� CK��ȡֵ����Ϊ��
	 * ��ck[i,j]ΪCK[i]�ĵ�[j]�ֽڣ�i=0,1,��,31�� j=0,1,2,3������CK[i] = (ck[i,0]�� ck[i,1]�� ck[i,2]�� ck[i,3]) �� (Z(2^8))^4��
	 * ��ck[i,j]= (4i+j)��7��mod 256����32 ���̶�����CKi���� 16 ���Ʊ�ʾΪ�� 
	 * 00070e15, 1c232a31, 383f464d, 545b6269, 
	 * 70777e85, 8c939aa1, a8afb6bd, c4cbd2d9, 
	 * e0e7eef5, fc030a11, 181f262d, 343b4249, 
	 * 50575e65, 6c737a81, 888f969d, a4abb2b9, 
	 * c0c7ced5, dce3eaf1, f8ff060d, 141b2229, 
	 * 30373e45, 4c535a61, 686f767d, 848b9299, 
	 * a0a7aeb5, bcc3cad1, d8dfe6ed, f4fb0209, 
	 * 10171e25, 2c333a41, 484f565d, 646b7279 
	 * </code>
	 */
	private static int[] CK = { 0x00070e15, 0x1c232a31, 0x383f464d, 0x545b6269,
			0x70777e85, 0x8c939aa1, 0xa8afb6bd, 0xc4cbd2d9, 0xe0e7eef5,
			0xfc030a11, 0x181f262d, 0x343b4249, 0x50575e65, 0x6c737a81,
			0x888f969d, 0xa4abb2b9, 0xc0c7ced5, 0xdce3eaf1, 0xf8ff060d,
			0x141b2229, 0x30373e45, 0x4c535a61, 0x686f767d, 0x848b9299,
			0xa0a7aeb5, 0xbcc3cad1, 0xd8dfe6ed, 0xf4fb0209, 0x10171e25,
			0x2c333a41, 0x484f565d, 0x646b7279 };

	/**
	 * ��������Կ
	 * 
	 * @param key
	 *            16�ֽڵļ�����Կ
	 * @return
	 */
	private static int[] sm4GetRoundKey(byte[] key) {
		int[] MK = new int[4];
		int[] k = new int[36];
		int[] SK = new int[32];
		MK[0] = bytes2int(key, 0);
		MK[1] = bytes2int(key, 4);
		MK[2] = bytes2int(key, 8);
		MK[3] = bytes2int(key, 12);
		k[0] = MK[0] ^ FK[0];
		k[1] = MK[1] ^ FK[1];
		k[2] = MK[2] ^ FK[2];
		k[3] = MK[3] ^ FK[3];
		for (int i = 0; i < 32; i++) {
			k[i + 4] = k[i]
					^ (sm4CalciRK(k[i + 1] ^ k[i + 2] ^ k[i + 3] ^ CK[i]));
			SK[i] = k[i + 4];
			//byte[] temp = int2bytes(SK[i]);
			//EasyBytes.hexDump("SK[" + i + "]=", temp);
		}
		return SK;
	}

	/**
	 * SM4��׼��һ�ּ���
	 * 
	 * @param sk
	 *            32�ֽڵ�����Կ
	 * @param input
	 *            ����
	 * @param inPostion
	 *            �������ʼλ��
	 * @param output
	 *            ���
	 * @param outPostion
	 *            �������ʼλ��
	 */
	private static void sm4_one_round(int[] sk, byte[] input, int inPostion,
			byte[] output, int outPostion) {
		int i = 0;
		int[] ulbuf = new int[36];
		ulbuf[0] = bytes2int(input, inPostion);
		ulbuf[1] = bytes2int(input, inPostion + 4);
		ulbuf[2] = bytes2int(input, inPostion + 8);
		ulbuf[3] = bytes2int(input, inPostion + 12);
		while (i < 32) {
			ulbuf[i + 4] = sm4F(ulbuf[i], ulbuf[i + 1], ulbuf[i + 2],
					ulbuf[i + 3], sk[i]);
			// #ifdef _DEBUG
			// printf("rk(%02d) = 0x%08x,  X(%02d) = 0x%08x \n",i,sk[i], i,
			// ulbuf[i+4] );
			// #endif
			i++;
		}
		int2bytes(output, ulbuf[35], outPostion);
		int2bytes(output, ulbuf[34], outPostion + 4);
		int2bytes(output, ulbuf[33], outPostion + 8);
		int2bytes(output, ulbuf[32], outPostion + 12);
	}

	private static int[] sm4GetRoundKeyForDecrypt(byte[] key) {
		int[] SK = sm4GetRoundKey(key);
		int[] SKDecrypt = new int[32];
		for (int i = 0; i < 32; i++) {
			SKDecrypt[i] = SK[32 - i - 1];
		}
		return SKDecrypt;
	}

	/**
	 * ����ECBģʽ��SM4�ӽ���
	 * 
	 * @param key
	 *            16�ֽ���Կ
	 * @param input
	 *            16�ֽ�����������
	 * @param encrypt
	 *            Ϊtrueʱ�Ǽ��ܣ�����Ϊ����
	 * @return
	 */
	private static byte[] sm4Ecb(byte[] key, byte[] input, boolean encrypt) {
		assert (key.length == 16); // ��Կ���ȱ�����16
		assert (input.length % 16 == 0);// ���볤�ȱ�����16�ı���
		int[] SK = null;
		if (encrypt) {
			SK = sm4GetRoundKey(key);
		} else {
			SK = sm4GetRoundKeyForDecrypt(key);
		}
		byte[] output = new byte[input.length];
		for (int i = 0; i < input.length; i = i + 16) {
			sm4_one_round(SK, input, i, output, i);
		}
		return output;
	}

	/**
	 * ����CBCģʽ��SM4�ӽ���,Ŀǰ�÷���δ�õ�
	 * 
	 * @param key
	 *            16�ֽ���Կ
	 * @param input
	 *            16�ֽ�����������
	 * @param iv
	 *            16�ֽ�����
	 * @param encrypt
	 *            Ϊtrueʱ�Ǽ��ܣ�����Ϊ����
	 * @return
	 */
	/**
	private static byte[] sm4Cbc(byte[] key, byte[] input, byte[] iv, boolean encrypt) {
		assert (key.length == 16); // ��Կ���ȱ�����16
		assert (input.length % 16 == 0);// ���볤�ȱ�����16�ı���
		int[] SK = null;
		if (encrypt) {
			SK = sm4GetRoundKey(key);
		} else {
			SK = sm4GetRoundKeyForDecrypt(key);
		}
		byte[] output = new byte[input.length];
		byte[] ivInProcess = new byte[16];// ���������������仯
		System.arraycopy(iv, 0, ivInProcess, 0, 16);
		for (int i = 0; i < input.length; i = i + 16) {
			if (encrypt) {
				// ʹ��������ԭ�Ľ������
				byte[] temp = new byte[16];
				for (int j = 0; j < 16; j++) {
					temp[j] = (byte) (ivInProcess[j] ^ input[i + j]);
				}
				// ����������м�������
				sm4_one_round(SK, temp, 0, output, i);
				// �Ѽ���������ģ�����Ϊ�´μ���ʹ�õ�����
				System.arraycopy(output, i, ivInProcess, 0, 16);
			} else {
				// �������ģ���Ϊ�´μ��������
				byte[] temp = new byte[16];
				System.arraycopy(input, i, temp, 0, 16);
				// �õ����ܵĳ�ʼ���
				sm4_one_round(SK, input, i, output, i);
				// ͨ�����õ�ԭ��
				for (int j = 0; j < 16; j++) {
					output[i + j] = (byte) (ivInProcess[j] ^ output[i + j]);
				}
				// �����ģ�����Ϊ�´μ���ʹ�õ�����
				System.arraycopy(temp, 0, ivInProcess, 0, 16);
			}
		}
		return output;
	}
	**/
    private static int blockLen = 16;
    
    private final static byte[] key = new byte[] { 0x01, 0x23, 0x45, 0x67, (byte) 0x89,
        (byte) 0xab, (byte) 0xcd, (byte) 0xef, (byte) 0xfe, (byte) 0xdc,
        (byte) 0xba, (byte) 0x98, 0x76, 0x54, 0x32, 0x10 };
    
    private static byte[] addPadding(byte[] src)
    {
        int num = (src.length / blockLen);
        byte paddingLen = (byte)(0xff & (blockLen * (num + 1) - src.length));
        byte[] newSrc = new byte[blockLen * (num + 1)];
        System.arraycopy(src, 0, newSrc, 0, src.length);
        for (int i = src.length; i < newSrc.length; i++)
        {
            newSrc[i] = paddingLen;
        }
        
        return newSrc;
    }
    
    private static byte[] delPadding(byte[] des)
    {
        byte last = des[des.length - 1];
        if ( last == des.length )
        {
            return new byte[0];
        }

        byte[] newDes = new byte[des.length - last];
        System.arraycopy(des, 0, newDes, 0, des.length - last);
        return newDes;
    }
    
    public static byte[] encrypt(byte[] src)
    {
        return encrypt(key,src);
    }

	public static byte[] encrypt(byte[] key,byte[] src)
	{
		byte[] paddingSrc = addPadding(src);
		byte[] result = sm4Ecb(key, paddingSrc, true);
		return result;
	}
    
    public static byte[] decrypt(byte[] des)
    {
        return decrypt(key,des);
    }

	public static byte[] decrypt(byte[] key,byte[] des)
	{
		byte[] paddingDes = sm4Ecb(key, des, false);
		paddingDes = delPadding(paddingDes);
		return paddingDes;
	}
	
	public static void main(String[] args) throws Exception
	{
	    String str = "KmailDbRoot2012!";
	    String encStr = new String(Base64.encode(encrypt(str.getBytes())));
	    System.out.println(encStr);
	    
	    byte[] desStrByte = decrypt(Base64.decode(encStr.getBytes()));
	    //ע��desStrByte�ĳ��ȿ���Ϊ0
	    if (desStrByte.length == 0) System.out.println("");
	    else
	    {
	        String desStr = new String(desStrByte);
	        System.out.println(desStr);
	    }
	}
}