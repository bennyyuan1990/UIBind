package com.benny.bindapt;

import com.benny.bindapt.annotation.ContentView;
import com.benny.bindapt.annotation.OnClick;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment env) {
        Messager messager = this.processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE,"Hello AnnotationProcessor");

        for (Element element:env.getElementsAnnotatedWith(ContentView.class)) {
           PackageElement packageElement = (PackageElement) element.getEnclosingElement();
           TypeElement classElement = (TypeElement) element;

           String packageName = packageElement.getQualifiedName().toString();
           String className = classElement.getSimpleName().toString();
           String fullClassName = classElement.getQualifiedName().toString();
            String simpleName = classElement.getSimpleName().toString();
            int value = classElement.getAnnotation(ContentView.class).value();

            messager.printMessage(Diagnostic.Kind.NOTE,"packageName : " + packageName);
            messager.printMessage(Diagnostic.Kind.NOTE,"className : " + className);
            messager.printMessage(Diagnostic.Kind.NOTE,"fullClassName : " + fullClassName);
            messager.printMessage(Diagnostic.Kind.NOTE,"simpleName : " + simpleName);
            messager.printMessage(Diagnostic.Kind.NOTE,"value : " + value);
        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> result = new LinkedHashSet<>();
        result.add(ContentView.class.getCanonicalName());
        result.add(OnClick.class.getCanonicalName());
        return result;
    }
}
