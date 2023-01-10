package uz.pdp.akshamnurserver.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum PermissionEnum implements GrantedAuthority {
    ADD_ROLE(PageEnum.ROLE),
    GET_ROLE(PageEnum.ROLE),
    EDIT_ROLE(PageEnum.ROLE),
    DELETE_ROLE(PageEnum.ROLE),
    ADD_PRODUCT(PageEnum.PRODUCT),
    EDIT_PRODUCT(PageEnum.PRODUCT),
    DELETE_PRODUCT(PageEnum.PRODUCT),
    GET_PRODUCT(PageEnum.PRODUCT),
    ADD_CATEGORY(PageEnum.CATEGORY),
    EDIT_CATEGORY(PageEnum.CATEGORY),
    GET_CATEGORY(PageEnum.CATEGORY),
    DELETE_CATEGORY(PageEnum.CATEGORY);

    private final PageEnum page;

    @Override
    public String getAuthority() {
        return name();
    }
}
