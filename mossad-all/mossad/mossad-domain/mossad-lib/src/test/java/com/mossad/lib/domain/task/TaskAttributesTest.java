package com.mossad.lib.domain.task;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaskAttributesTest {

    private TaskAttributes taskAttributes;
    private String description = "test description";
    private long priority = 0;
    private long status = 2;
    private String title = "TAsk title";
    private long type = 1;
    private long user = 123456789;

    @Before
    public void setUp() {
        taskAttributes = new TaskAttributes();
    }

    @After
    public void tearDown() {
        taskAttributes = null;
    }

    @Test
    public void testTaskAttributes() {

        Assert.assertNotNull(taskAttributes);

        taskAttributes.setDescription(description);
        taskAttributes.setPriority(priority);
        taskAttributes.setStatus(status);
        taskAttributes.setTitle(title);
        taskAttributes.setType(type);
        taskAttributes.setUser(user);

        String myDescription = taskAttributes.getDescription();
        Assert.assertEquals(myDescription, description);

        long myPriority = taskAttributes.getPriority();
        Assert.assertEquals(myPriority, priority);

        long myStatus = taskAttributes.getStatus();
        Assert.assertEquals(myStatus, status);

        String myTitle = taskAttributes.getTitle();
        Assert.assertEquals(myTitle, title);

        long myType = taskAttributes.getType();
        Assert.assertEquals(myType, type);

        long myUser = taskAttributes.getUser();
        Assert.assertEquals(myUser, user);

    }
}
