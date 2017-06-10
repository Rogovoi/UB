package userbase.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import userbase.models.SecurityUser;
import userbase.service.SecurityUserService;


@Component
public class SecurityUserValidator implements Validator{

    @Autowired
    private SecurityUserService securityUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SecurityUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SecurityUser securityUser = (SecurityUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (securityUser.getLogin().length() < 5 || securityUser.getLogin().length() > 20){
            errors.rejectValue("login", "Size.loginForm.login");
        }

        if (securityUserService.findUserByLogin(securityUser.getLogin()) != null){
            errors.rejectValue("login", "Duplicate.loginForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (securityUser.getPassword().length() < 5){
            errors.rejectValue("password", "Size.loginForm.password");
        }

        if (!securityUser.getConfirmPassword().equals(securityUser.getPassword())){
            errors.rejectValue("confirmPassword", "Different.loginForm.password");
        }
    }

}
