package org.dream.thymeleafconfig;

import org.thymeleaf.context.IContext;
import org.thymeleaf.util.Validate;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class AbstractContext implements IContext {


    private final Map<String,Object> variables;
    private Locale locale;


    protected AbstractContext() {
        this(Locale.getDefault());
    }


    protected AbstractContext(final Locale locale) {
        super();
        Validate.notNull(locale, "Locale cannot be null");
        this.locale = locale;
        this.variables = new LinkedHashMap<String, Object>(10);
    }


    protected AbstractContext(final Locale locale, final Map<String, Object> variables) {
        super();
        Validate.notNull(locale, "Locale cannot be null");
        Validate.notNull(variables, "Variables map cannot be null");
        this.locale = locale;
        this.variables = new LinkedHashMap<String, Object>(variables);
    }


    public final Locale getLocale() {
        return this.locale;
    }

    public final boolean containsVariable(final String name) {
        return this.variables.containsKey(name);
    }

    public final Set<String> getVariableNames() {
        return this.variables.keySet();
    }


    public final Object getVariable(final String name) {
        return this.variables.get(name);
    }


    /**
     * <p>
     *   Sets the locale to be used.
     * </p>
     *
     * @param locale the locale.
     */
    public final void setLocale(final Locale locale) {
        Validate.notNull(locale, "Locale cannot be null");
        this.locale = locale;
    }


    /**
     * <p>
     *   Sets a new variable into the context.
     * </p>
     *
     * @param name the name of the variable.
     * @param value the value of the variable.
     */
    public final void setVariable(final String name, final Object value) {
        this.variables.put(name, value);
    }


    /**
     * <p>
     *   Sets several variables at a time into the context.
     * </p>
     *
     * @param variables the variables to be set.
     */
    public final void setVariables(final Map<String,Object> variables) {
        if (variables == null) {
            return;
        }
        this.variables.putAll(variables);
    }


    /**
     * <p>
     *   Removes a variable from the context.
     * </p>
     *
     * @param name the name of the variable to be removed.
     */
    public final void removeVariable(final String name) {
        this.variables.remove(name);
    }


    /**
     * <p>
     *   Removes all the variables from the context.
     * </p>
     */
    public final void clearVariables() {
        this.variables.clear();
    }


}
