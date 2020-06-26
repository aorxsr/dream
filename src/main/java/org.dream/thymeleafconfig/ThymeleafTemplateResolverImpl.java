package org.dream.thymeleafconfig;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import java.util.Map;

/**
 * 模板试图
 */
public class ThymeleafTemplateResolverImpl extends AbstractConfigurableTemplateResolver {
    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration,
                                                        String ownerTemplate, String template, String resourceName,
                                                        String characterEncoding, Map<String, Object> templateResolutionAttributes) {

        return new ThymeleafTemplateResourceImpl(resourceName, characterEncoding);
    }
}
