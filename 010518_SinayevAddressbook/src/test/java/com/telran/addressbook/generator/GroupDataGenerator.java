package com.telran.addressbook.generator;

import com.telran.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupDate> groups = generateGroups(count);

        save(groups,file);
    }

    private static List<GroupDate> generateGroups(int count) {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        for(int i = 0; i < count; i++){
            groups.add(new GroupDate().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));

        }
        return groups;
    }

    private static void save(List<GroupDate> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupDate group : groups) {
            writer.write(String.format("%s; %s; %s;\n",
                    group.getNameGroup(), group.getHeader(), group.getFooter()));

        }
        writer.close();
    }

}
