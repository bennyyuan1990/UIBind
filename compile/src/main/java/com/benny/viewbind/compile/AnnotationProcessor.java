package com.benny.viewbind.compile;

import com.benny.viewbind.BindContentView;
import com.benny.viewbind.BindView;
import com.benny.viewbind.OnClick;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;


//AutoService自动生成META-INF/services/javax.annotation.processing.Processor文件
@AutoService(Process.class)
public class AnnotationProcessor extends AbstractProcessor {
    private Messager mMessager;
    private Elements mElementUtils;

    /**
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> result = new LinkedHashSet<>();
        result.add(BindView.class.getCanonicalName());
        result.add(BindContentView.class.getCanonicalName());
        result.add(OnClick.class.getCanonicalName());
        return result;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mMessager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> bindViewElements = roundEnv.getElementsAnnotatedWith(BindView.class);

        for (Element element: bindViewElements) {
            logNote(element.toString());
        }
        return false;
    }


    private void logNote(String msg) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, msg);
    }

    private void logNote(String format, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(format, args));
    }


}
