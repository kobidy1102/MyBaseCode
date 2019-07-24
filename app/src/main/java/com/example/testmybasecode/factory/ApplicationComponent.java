package com.example.testmybasecode.factory;


import com.example.testmybasecode.domain.login.LoginActivity;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity); // tạo liên kết tới nơi cần object mà Module đã khởi tạo
}
