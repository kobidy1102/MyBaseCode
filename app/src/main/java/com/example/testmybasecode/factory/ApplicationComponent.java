package com.example.testmybasecode.factory;


import com.example.testmybasecode.service.authentication.RestAuthenticationService;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
   // void inject(LoginActivity loginActivity); // tạo liên kết tới nơi cần object mà Module đã khởi tạo
     RestAuthenticationService provideAuthenticationService();
}
