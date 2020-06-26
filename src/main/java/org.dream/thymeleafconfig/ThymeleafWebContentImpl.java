package org.dream.thymeleafconfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.ael.http.WebContent;
import org.ael.http.body.Body;
import org.ael.http.body.StringBody;
import org.ael.http.body.ViewBody;
import org.ael.http.inter.Request;
import org.ael.http.inter.Response;
import org.ael.http.inter.Session;
import org.ael.template.ModelAndView;
import org.thymeleaf.context.IContext;

import javax.swing.text.View;
import java.util.Locale;
import java.util.Map;

public class ThymeleafWebContentImpl extends AbstractContext implements IContext {
    private final Request request;
    private final Response response;
    private final WebContent WebContent;

    public ThymeleafWebContentImpl(final Request request, final Response response,
                                   final WebContent WebContent) {
        super();
        this.request = request;
        this.response = response;
        this.WebContent = WebContent;

        Object body = response.getBody();

        if (body instanceof ViewBody) {
            ViewBody viewBody = (ViewBody) body;
            ModelAndView modelAndView = viewBody.getModelAndView();
            if (null == modelAndView) {
                return;
            }
            Map<String, Object> model = modelAndView.getModel();
            if (null != model) {
                setVariables(model);
            }
        }

    }

    public ThymeleafWebContentImpl(final Request request, final Response response,
                                   final WebContent WebContent, final Locale locale) {
        super(locale);
        this.request = request;
        this.response = response;
        this.WebContent = WebContent;
    }

    public ThymeleafWebContentImpl(final Request request, final Response response,
                                   final WebContent WebContent, final Locale locale, final Map<String, Object> variables) {
        super(locale, variables);
        this.request = request;
        this.response = response;
        this.WebContent = WebContent;
    }


    public Request getRequest() {
        return this.request;
    }

    public Session getSession() {
        return this.request.getSession();
    }

    public Response getResponse() {
        return this.response;
    }

    public WebContent getWebContent() {
        return this.WebContent;
    }
}
