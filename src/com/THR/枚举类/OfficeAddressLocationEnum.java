package com.THR.ö����;

public enum OfficeAddressLocationEnum {

    NONE_OFFICE_ADDRESS(-1, "δ֪"),
    LOCAL_OFFICE_ADDRESS(0, "����"),
    REMOTE_OFFICE_ADDRESS(1, "���");

    private Integer officeAddressTypeId;
    private String officeAddressTypeDes;

    OfficeAddressLocationEnum(Integer officeAddressTypeId, String officeAddressTypeDes) {
        this.officeAddressTypeId = officeAddressTypeId;
        this.officeAddressTypeDes = officeAddressTypeDes;
    }

    public static OfficeAddressLocationEnum getOfficeAddressTypeEnum(Integer officeAddressTypeId) {
        if (null != officeAddressTypeId) {
            for (OfficeAddressLocationEnum typeEnum : OfficeAddressLocationEnum.values()) {
                if (officeAddressTypeId.equals(typeEnum.officeAddressTypeId)) {
                    return typeEnum;
                }
            }
        }
        return NONE_OFFICE_ADDRESS;
    }

    /**
     * �õ��෴�İ칫λ�����ͣ�Ŀǰ��֧�����ֻ�����
     * @param officeAddressLocationEnum
     * @return
     */
    public static OfficeAddressLocationEnum getOppositeOfficeAddressTypeEnum(OfficeAddressLocationEnum officeAddressLocationEnum) {
        if (null == officeAddressLocationEnum) {
            return null;
        }
        OfficeAddressLocationEnum oppositeOfficeAddressTypeEnum = null;
        if (officeAddressLocationEnum == LOCAL_OFFICE_ADDRESS) {
            oppositeOfficeAddressTypeEnum = OfficeAddressLocationEnum.REMOTE_OFFICE_ADDRESS;
        } else if (officeAddressLocationEnum == REMOTE_OFFICE_ADDRESS) {
            oppositeOfficeAddressTypeEnum = OfficeAddressLocationEnum.LOCAL_OFFICE_ADDRESS;
        }
        return oppositeOfficeAddressTypeEnum;
    }

    public Integer getOfficeAddressTypeId() {
        return officeAddressTypeId;
    }

    public String getOfficeAddressTypeDes() {
        return officeAddressTypeDes;
    }
}
