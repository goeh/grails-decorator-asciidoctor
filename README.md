# Asciidoctor Decorator - Grails Plugin


This plugin adds Asciidoctor support to the [decorator](https://github.com/goeh/grails-decorator) plugin.
The decorator plugin uses pluggable decorators to modify markup in GSP pages.
The standard decorator can convert URLs www.mycompany.com to clickable hyperlinks.
This plugin extends the decorator plugin and adds support for Asciidoctor syntax in parts of GSP pages.

-----

# Usage Examples

    // The model
    text = "Asciidoctor is *awesome!*"

    // GSP markup
    <g:decorate>${text}</g:decorate>

Produces the following HTML:

\<p>Asciidoctor is \<strong>awesome!\</strong>\</p>

which renders:

Asciidoctor is **awesome!**

You can use this plugin in your Grails application to allow your users to add Asciidoctor syntax to user profiles, comments, etc.
Or maybe render dynamic context sensitive help that are maintained in Asciidoctor format.

The source code for this decorator is **very** simple. It uses the [asciidoctor-java-integration](https://github.com/asciidoctor/asciidoctorj) library.

This plugin also adds an `asciidoctor` bean to the Spring context that you can use directly if have special requirements.

    class AsciidoctorDecorator {

        def asciidoctor

        String decorate(String text, Map params) {
            asciidoctor.render(text, params)
        }
    }

# See also

## Markdown decorator
The [Markdown Decorator](https://github.com/goeh/grails-decorator-markdown) plugin is an example of an extension plugin that adds Markdown syntax support.
