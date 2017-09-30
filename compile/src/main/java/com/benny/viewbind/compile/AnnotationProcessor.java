package com.benny.viewbind.compile;

import com.benny.viewbind.BindContentView;
import com.benny.viewbind.BindView;
import com.benny.viewbind.OnClick;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

public class AnnotationProcessor extends AbstractProcessor {

    /**
     * 处理支持的注解类型
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> result = new HashSet<>();
        result.add(BindView.class.getCanonicalName());
        result.add(BindContentView.class.getCanonicalName());
        result.add(OnClick.class.getCanonicalName());
        return result;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
