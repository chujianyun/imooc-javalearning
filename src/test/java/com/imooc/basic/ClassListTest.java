package com.imooc.basic;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassListTest {

    @org.junit.Test
    public void test() {

        String prefix = "/Users/liuwangyang/Library/Mobile Documents/com~apple~CloudDocs/资源/知识付费/慕课网/我的Java学习和趟坑之路/";

        List<String> originDirs = Stream.of(new File(prefix).listFiles())
                .filter(File::isDirectory)
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());


        for (String parentName : originDirs) {
            File dir = new File(prefix + parentName);

            AndFileFilter andFileFilter = new AndFileFilter();
            andFileFilter.addFileFilter(new SuffixFileFilter(".md"));
            Collection<File> files = FileUtils.listFilesAndDirs(dir, andFileFilter, null);

            List<File> dirs = files.stream()
                    .filter(File::isDirectory)
                    .collect(Collectors.toList());

            String dirName = dirs.get(0).getName();

            int numberIndex = dirName.indexOf("0");
            String pre = "第" + dirName.substring(numberIndex + 1, numberIndex + 2) + "章";
            int blankIndex = dirName.indexOf(" ");

            if (blankIndex < 0) {
                continue;
            }
            System.out.println(pre + dirName.substring(blankIndex));

            files.stream()
                    .filter(File::isFile)
                    .sorted(Comparator.comparing(File::getName))
                    .forEach(file -> {
                        String name = file.getName();
                        int index = name.indexOf(".md");
                        System.out.println(name.substring(0, index));
                    });
        }
    }

}
