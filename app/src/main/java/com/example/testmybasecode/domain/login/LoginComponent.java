package com.example.testmybasecode.domain.login;


import com.example.testmybasecode.factory.ApplicationComponent;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class) //note: dêpendencies thằng AppComponent ,
// phụ thuộc vào nó, xài lại nhưng cái nó đã có, tượng tự kế thừa, nếu thằng Con này có cái mới thì khai báo thêm một lớp Module.
public interface LoginComponent {
    void inject(LoginActivity loginActivity); // tạo liên kết tới nơi cần object mà Module đã khởi tạo
}
