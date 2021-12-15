package utils;

import org.json.JSONObject;

public class APIpayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Bruce\",\n" +
                "  \"emp_lastname\": \"Wayne\",\n" +
                "  \"emp_middle_name\": \"Mars\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1985-11-07\",\n" +
                "  \"emp_status\": \"Active\",\n" +
                "  \"emp_job_title\": \"Caped Crusader\"\n" +
                "}";
        return createEmployeePayload;
    }
    public static String createEmployeeBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Bruce");
        obj.put("emp_lastname","Wayne");
        obj.put("emp_middle_name","Mars");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1985-11-07");
        obj.put("emp_status","Active");
        obj.put("emp_job_title","Caped Crusader");

        return obj.toString();
    }

    public static String payloadMoreDynamic
            (String emp_firstname, String emp_lastname, String emp_middle_name,
             String emp_gender, String emp_birthday, String emp_status, String job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",job_title);

        return obj.toString();
    }
}
