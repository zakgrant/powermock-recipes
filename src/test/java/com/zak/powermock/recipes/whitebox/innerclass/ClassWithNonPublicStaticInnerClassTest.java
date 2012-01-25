package com.zak.powermock.recipes.whitebox.innerclass;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.powermock.reflect.Whitebox.getInnerClassType;
import static org.powermock.reflect.Whitebox.invokeMethod;
import static org.powermock.reflect.Whitebox.newInstance;
import static org.powermock.reflect.Whitebox.setInternalState;

import com.zak.powermock.recipes.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ClassWithNonPublicStaticInnerClassTest extends TestHelper {

    private ClassWithNonPublicStaticInnerClass sut;
    private Class sutClass;

    @Before
    public void setUp() {

        sut = new ClassWithNonPublicStaticInnerClass();
        sutClass = sut.getClass();
    }

    @Test
    public void shouldGainAccessToProtectedInnerClass() throws ClassNotFoundException {
        setInstance("ProtectedInnerClass", "protectedInnerClass");
        String description = sut.getProtectedInnerClass().getDescription();
        validateDescription(description);
    }

    @Test
    public void shouldGainAccessToPrivateInnerClass() throws Exception {
        setInstance("PrivateInnerClass", "privateInnerClass");
        String description = invokeMethod(sut.getPrivateInnerClass(), "getDescription");
        validateDescription(description);
    }

    private void validateDescription(String description) {
        assertThat(description, is(not((String)null)));
        logger.info(description);
    }

    private void setInstance(String className, String instanceName) throws ClassNotFoundException {
        Class<Object> privateInnerClass = getInnerClassType(sutClass, className);
        setInternalState(sut, instanceName, newInstance(privateInnerClass));
    }
}
