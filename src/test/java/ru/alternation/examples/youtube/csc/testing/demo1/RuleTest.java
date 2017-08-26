package ru.alternation.examples.youtube.csc.testing.demo1;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    @Ignore
    public void demo() throws Exception {
        tempFolder.newFile();
    }
}
