package www.tom.com.stringdemo;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
@Slf4j
public class StringBean {
    @Pattern(regexp = "\\A(?!\\s*\\Z).+")
    String someString;


    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        StringBean stringBean=new StringBean();
        stringBean.setSomeString("Abbbb");
        Set<ConstraintViolation<StringBean>> violations = validator.validate(stringBean);
        for (ConstraintViolation<StringBean> violation : violations) {
            log.error(violation.getMessage());
        }
    }
}