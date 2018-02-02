package jd_shopping_mall.linsir.top.apt.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;
import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import jd_shopping_mall.linsir.top.apt.AnnotationProcessor;
import jd_shopping_mall.linsir.top.apt.interfaces.IProcessor;
import jd_shopping_mall.linsir.top.apt.util.Utils;


/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public class InstanceProcessor  implements IProcessor {
    @Override
    public void process(RoundEnvironment roundEnv, AnnotationProcessor mAbstractProcessor) {
        TypeElement mElment=null;
        String CLASS_NAME = "InstanceFactory";
        TypeSpec.Builder tb = classBuilder(CLASS_NAME).addModifiers(PUBLIC, FINAL).addJavadoc("@ 实例化工厂 此类由apt自动生成");
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("create")
                .addJavadoc("@此方法由apt自动生成")
                .returns(Object.class)
                .addModifiers(PUBLIC, STATIC)
                .addException(IllegalAccessException.class)
                .addException(InstantiationException.class)
                .addParameter(Class.class, "mClass");

        List<ClassName> mList = new ArrayList<>();
        CodeBlock.Builder blockBuilder = CodeBlock.builder();
        blockBuilder.beginControlFlow(" switch (mClass.getSimpleName())");//括号开始
        try {
            for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(InstanceFactory.class))) {
                mAbstractProcessor.mMessager.printMessage(Diagnostic.Kind.NOTE, "正在处理: " + element.toString());
                if(mElment==null)mElment=element;
                if (!Utils.isValidClass(mAbstractProcessor.mMessager, element)) return;
                ClassName currentType = ClassName.get(element);
                if (mList.contains(currentType)) continue;
                mList.add(currentType);
                blockBuilder.addStatement("case $S: return  new $T()", currentType.simpleName(), currentType);//初始化Presenter
            }
            blockBuilder.addStatement("default: return mClass.newInstance()");
            blockBuilder.endControlFlow();
            methodBuilder.addCode(blockBuilder.build());
            tb.addMethod(methodBuilder.build());
            if(mElment==null){
                return;
            }
            JavaFile javaFile = JavaFile.builder("top.linsir.jd_shopping_mall.apt", tb.build()).build();// 生成源代码
            javaFile.writeTo(mAbstractProcessor.mFiler);// 在 app module/build/generated/source/apt 生成一份源代码
        } catch (FilerException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
