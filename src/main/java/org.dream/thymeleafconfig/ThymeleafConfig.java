package org.dream.thymeleafconfig;

import cn.hutool.extra.template.engine.thymeleaf.ThymeleafEngine;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.ael.Ael;
import org.ael.Environment;
import org.ael.exception.ViewNotFoundException;
import org.ael.http.WebContent;
import org.ael.http.body.ViewBody;
import org.ael.template.AelTemplate;
import org.ael.template.ModelAndView;
import org.ael.template.give.ReadStaticResources;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.IOException;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class ThymeleafConfig implements AelTemplate {


    private TemplateEngine engine = null;

    @Override
    public WebContent render(ModelAndView modelAndView, WebContent webContent) throws ViewNotFoundException {
        ThymeleafWebContentImpl content = new ThymeleafWebContentImpl(webContent.getRequest(), webContent.getResponse(), webContent);
        String process = engine.process(modelAndView.getView(), content);
        webContent.getResponse().write(ViewBody.of(process));
        return webContent;
    }

    @Override
    public FullHttpResponse renderResponse(ModelAndView modelAndView, WebContent webContent) throws ViewNotFoundException {
        // 这里 进行 模板，，，
        webContent = render(modelAndView, webContent);
        ThymeleafWebContentImpl content = new ThymeleafWebContentImpl(webContent.getRequest(), webContent.getResponse(), webContent);
        String process = engine.process(modelAndView.getView(), content);
        return new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(process.getBytes()));
    }

    @Override
    public void init(Ael ael) {
        Environment environment = ael.getEnvironment();
        /**
         * thymeleaf.prefix
         * thymeleaf.suffix
         * thymeleaf.mode
         * thymeleaf.cacheable
         * thymeleaf.encoding
         */
        // 1
        ThymeleafTemplateResolverImpl resolver = new ThymeleafTemplateResolverImpl();
        resolver.setPrefix(environment.getString("thymeleaf.prefix"));
        resolver.setSuffix(environment.getString("thymeleaf.suffix"));
        resolver.setTemplateMode(environment.getString("thymeleaf.mode", "HTML"));
        resolver.setCharacterEncoding(environment.getString("thymeleaf.encoding", "UTF-8"));
        if (environment.containsKey("thymeleaf.cacheable")) {
            resolver.setCacheable(environment.getBoolean("thymeleaf.cacheable", false));
        }
        // 2
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        this.engine = engine;
    }

    @Override
    public ReadStaticResources readFileContext(String view) throws ViewNotFoundException, IOException {
        return null;
    }

}
