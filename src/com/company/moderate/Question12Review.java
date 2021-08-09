package com.company.moderate;

//XML Encoding: Since XML is very verbose, you are given a way of encoding it where each tag gets
//        mapped to a pre-defined integer value. The language/grammar is as follows:
//        Element --> Tag Attributes END Children END
//        Attribute --> Tag Value
//        END --> 0
//        Tag --> some predefined mapping to int
//        Value --> string value
//        For example, the following XML might be converted into the compressed string below (assuming a
//        mapping of family -> 1, person ->2, firstName -> 3, lastName -> 4, state
//        -> 5).
//<family lastName="McDowell" st ate="CA">
//<person firs tName="Gayle">Some Message</person>
//</family>
//        Becomes:
//        1 4 McDowell SCA 0 2 3 Gayle 0 Some Message 0 0
//        Write code to print the encoded version of an XML element (passed in Element and Attribute
//        objects).


import java.util.HashMap;
import java.util.Map;

public class Question12Review {

    public Question12Review() {
        String xml =  "<family lastName=\"McDowell\" state=\"CA\">\n" +
                      "<person firstName=\"Gayle\">Some Message</person>\n" +
                      "</family>";

        Map<String, Integer> tags = new HashMap<>();
        tags.put("family", 1);
        tags.put("person", 2);
        tags.put("firstName", 3);
        tags.put("lastName", 4);
        tags.put("state", 5);


        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        boolean tag = false;

        int index = 0;

        for (char ch : xml.toCharArray()) {
            if (ch == '<') {
                tag = true;
                continue;
            }

            if (ch == '>') {
                stringBuilder.append(buffer.toString());
                buffer.setLength(0);
                stringBuilder.append("0");
                tag = false;
            }

            if (tag && ch == '\"') continue;

            if (ch == ' ' || (tag && ch == '=')) {
                stringBuilder.append(' ');
                String bufferString = buffer.toString();
                if (tags.containsKey(bufferString)) {
                    stringBuilder.append(tags.get(bufferString));
                } else {
                    stringBuilder.append(bufferString);
                }
                buffer.setLength(0);
                continue;
            }

            buffer.append(ch);
        }

        System.out.println(stringBuilder.toString());
    }


}
