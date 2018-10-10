package com.THR.√∂æŸ¿‡;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thr
 */
public class TestEnum {

    public static void main(String args[]){
        Map<OfficeAddressLocationEnum, String> enumStringMap = new HashMap<>();
        OfficeAddressLocationEnum officeAddressLocationEnum = OfficeAddressLocationEnum.getOfficeAddressTypeEnum(0);
        enumStringMap.put(officeAddressLocationEnum, "abcd");
        System.out.println(enumStringMap.get(OfficeAddressLocationEnum.LOCAL_OFFICE_ADDRESS));
    }
}
