import org.junit.Test;
//import sun.misc.Unsafe;
import www.tom.com.oop.constructuers.User;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
public class UserTest {
    @Test
    public void whenIntializedWithNew_thenInstanceIsNotNull() {
        User user = new User();

        assertThat(user).isNotNull();
    }

    /**
     * 23:46:22.143 [main] INFO www.tom.com.User - static variables and static initializers in order
     * instance variables and instance initializers in order
     * 23:46:22.145 [main] INFO www.tom.com.User - constructors
     */
    @Test
    public void testOrderOfInitialization() {
        User user = new User("Alice", 1);
    }
    @Test
    public void whenValuesAreNotInitialized_thenUserNameAndIdReturnDefault() {
        User user = new User();

        assertThat(user.getName()).isNull();
        assertThat(user.getId() == 0);
    }

    @Test
    public void whenInitializedWithReflection_thenInstanceIsNotNull()
            throws Exception {
        User user = User.class.getConstructor(String.class, int.class)
                .newInstance("Alice", 2);

        assertThat(user).isNotNull();
    }
    @Test
    public void whenCopiedWithClone_thenExactMatchIsCreated()
            throws CloneNotSupportedException {
        User user = new User("Alice", 3);
        User clonedUser = (User) user.clone();

        assertThat(clonedUser).isEqualTo(user);
    }
    @Test
    public void test1()
            throws InstantiationException {
         //Unsafe unsafeInstance =  Unsafe.getUnsafe();

       // User u = (User) unsafeInstance.allocateInstance(User.class);
    }
}
