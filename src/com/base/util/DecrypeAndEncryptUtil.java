package com.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DecrypeAndEncryptUtil {

    private static char[] FIX_CHAR = new char[] {
            'Z','!','*','1','E','V','%','W'
    };

    private static final String DATA_SECRET_KEY_FIXED_SUFFIX = "_KL!@0UM";
    private static final String REQ_ILLEGAL_SECRET_KEY_FIXED_SUFFIX = "_%@_$9KM";


    /**
     * 生成IG加密秘钥
     * @param domain
     * @return
     */
    public static final String getIllegalSecretKey(String domain) {
        return getSecretKeyPrefix(domain) + REQ_ILLEGAL_SECRET_KEY_FIXED_SUFFIX;
    }

    /**
     * 数据相关秘钥
     * @param preKey 可以是接入码或者域名前八位
     * @return
     */
    public static final String getDataSecretKey(String preKey) {
        return preKey + DATA_SECRET_KEY_FIXED_SUFFIX;
    }

    /**
     * 加密接入码
     * @param attachCode
     * @return
     */
    public static final String encryptAttachCode(String attachCode) {
        return new String(Base64.encode(Sm4Util.encrypt(attachCode.getBytes())));
    }

    /**
     * 解密接入码
     * @param attachCode 未解密的接入码
     * @return
     */
    public static final String decryptAttachCode(String attachCode) {
        return new String(Sm4Util.decrypt(Base64.decode(attachCode.getBytes())));
    }

    public static String encrypt(byte[] secretKey,String data) {
        return new String(Base64.encode(Sm4Util.encrypt(secretKey,data.getBytes())));
    }

    /**
     * 非法请求参数检验
     * @param secretKey
     * @param data
     * @return
     */
    public static String decrypt(byte[] secretKey,String data) {
        return new String(Sm4Util.decrypt(secretKey,Base64.decode(data.getBytes())));
    }

    /**
     * 通过域名生成固定密码的前8个字节
     * @param domain
     * @return
     */
    public static final String getSecretKeyPrefix(String domain) {
        StringBuilder secretKeyBuilder = new StringBuilder(8);
        int appendCharCount = 8;
        if(StringUtil.isNotEmpty(domain)) {
            if(domain.trim().length() >= 8) {
                secretKeyBuilder.append(domain.trim().substring(0,8));
                appendCharCount = 0;
            }
            else {
                secretKeyBuilder.append(domain.trim());
                appendCharCount = appendCharCount - domain.trim().length();
            }
        }
        if(appendCharCount > 0) {
            for(int i = 0; i < appendCharCount; i++) {
                secretKeyBuilder.append(FIX_CHAR[i]);
            }
        }
        return secretKeyBuilder.toString();
    }

    public static void main(String args[]) throws UnsupportedEncodingException {

        /**
         * 申请接入
         */
        String domain = "www.test1.com";
        //得到Ig
        String igKey = getIllegalSecretKey(domain);
        String ig = encrypt(igKey.getBytes(),"12345678");
        ig = URLEncoder.encode(ig,"GBK");
        System.out.println("ig:" + ig);
        //得到数据加密秘钥
        String dataKey = getDataSecretKey(getSecretKeyPrefix(domain));
        String data = "{\"ip\":\"192.168.42.220\",\"name\":\""+domain+"\"}";
        data = encrypt(dataKey.getBytes(), data);
        data = URLEncoder.encode(data,"GBK");
        System.out.println("data:" + data);


        //得到接入码
        String unAttachCode = "+oaf2dcYwgGFQ8B4Vb09+w==";
        String dsData = "U/QCNq+RhNXDiqTuA1yP3bIJekAmzz7DQL8cDxisn8kwDL/4FDJTDydN3lzMlIQpO4NylGLh4G6rCRgqRfdeimcDGgzkfyi05dv46tieyuabxk+QqjCthJ8rDmBuvI8NWFs5PLYp5KAqcdg6uPln6qHlscdVw6WQYyBavcmJglqcdGpeRmX8a3qHaQxjgAXWs2fQt99UghmN7qmXzB7jTew2NgpJ7sjzTiTEggxEdOfiaZ/kXECO1ibH0TAGinmYi4lYeo6fvVUEJ/OQ+LkhV/+/8zVpFEMiZVhd77MQQTIRz9Bz6hOCcEyQxSwgvSNa+cD6B0gTHm4zQ3kRDSru3I8xdaNsTfVvKJSBmY33z4JnG4UFJSDh6mvwgpSFdvRRis8kOVkzOFlsMlI4qwlDibukGkX76UfmUGOjILy69a81/OxoWmd3u1L6XyCFujHf";
        System.out.println(decrypt(getDataSecretKey(decryptAttachCode(unAttachCode)).getBytes(),dsData));
        dsData = "boLgq7GVgbCPlbSbXqrbkiZNmteS6drAa2XkjJGb2GKoGmFcWFZDUCZ1OmIFYM6llg//OxRTawrMBWQx2i91AgwsfljrKmFBdq6z/OyMa0swV3bALRhyE3q6bpKKAG82i+fiVn8mPB2I5VjxF4TpvA==";
        System.out.println(decrypt(getDataSecretKey(decryptAttachCode(unAttachCode)).getBytes(),dsData));
        dsData = "U/QCNq+RhNXDiqTuA1yP3bIJekAmzz7DQL8cDxisn8kwDL/4FDJTDydN3lzMlIQpO4NylGLh4G6rCRgqRfdeimcDGgzkfyi05dv46tieyubWclxEhoiIgEWLdoejgzSouQe409O7EP/I1z/3dj1yJWrwkGJkNb9RL+0d2dshNkOV9+FrAaWrtvfOsbJ1VBdxLKKBubZXaNOkSXUpaI4BzWjr3bogMJhytNyY4HX89fPHqOo+dWcxnFkVssL8GqdU1aIMyNdgFPjzpjXI4aP8mHEGAA5WW3VOp/bjhG8jfFE3ythNMsC++DBbQrHu6K1GvmokN2skX6Q+jN6uWZrjKgTqvytexhnvrfjkFza8vi1NdeEvJtgKgH5o5d2iQsgB11CfHuR/DBoO4MTHlyrKdw+sx1SlX+bVb0rZpTyik8xPZvExZMwPZuu9tS/qAFIHy7PmidNrjWLJysb5Fp30YQGFMuISjT8Kqx3IGa+ongjl9ehLxL9Rhor4oqilNSvZkd/kKXDTFQcPQHwTkhCcvl9b2w4NftQtLkQzJ63it2Yhg4H5KZM0jTGtIHpNX0G7";
        System.out.println(decrypt(getDataSecretKey(decryptAttachCode(unAttachCode)).getBytes(),dsData));

    }


}
