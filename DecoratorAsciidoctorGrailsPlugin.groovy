/*
 * Copyright (c) 2014 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class DecoratorAsciidoctorGrailsPlugin {
    def version = "0.3"
    def grailsVersion = "2.0 > *"
    def dependsOn = [:]
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    def title = "Asciidoctor Decorator Plugin"
    def author = "Goran Ehrsson"
    def authorEmail = "goran@technipelago.se"
    def description = '''\
This plugin adds Asciidoctor support to the decorator plugin.
The decorator plugin uses pluggable decorators to modify markup in GSP pages.
The standard decorator can convert URLs www.mycompany.com to clickable hyperlinks.
This plugin extends the decorator plugin and adds support for Asciidoctor syntax in parts of GSP pages.
'''
    def documentation = "https://github.com/goeh/grails-decorator-asciidoctor"
    def license = "APACHE"
    def organization = [ name: "Technipelago AB", url: "http://www.technipelago.se/" ]

    def issueManagement = [ system: "github", url: "https://github.com/goeh/grails-decorator-asciidoctor/issues" ]
    def scm = [ url: "https://github.com/goeh/grails-decorator-asciidoctor" ]

    def doWithSpring = {
        asciidoctor(org.asciidoctor.Asciidoctor.Factory) { bean->
            bean.factoryMethod = 'create'
        }
    }
}
