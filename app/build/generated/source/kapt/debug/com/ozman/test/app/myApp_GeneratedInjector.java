package com.ozman.test.app;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = myApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface myApp_GeneratedInjector {
  void injectmyApp(myApp myApp);
}
