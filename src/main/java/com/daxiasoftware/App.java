package com.daxiasoftware;

import org.apache.commons.io.IOUtils;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        String result = getDiskUsage();
        System.out.println(result);
    }

    private static String getDiskUsage() throws Exception {
        String cmd = "df -lhT | grep ext | awk '{print $6}'";
        String[] cmds = null;
        cmds = new String[] { "sh", "-c", cmd };
        Process p = Runtime.getRuntime().exec(cmds);
        p.waitFor();
        String output = IOUtils.toString(p.getInputStream());
        return output;
    }
}
