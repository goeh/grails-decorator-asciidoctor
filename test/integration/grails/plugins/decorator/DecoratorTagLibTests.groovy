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

package grails.plugins.decorator

import grails.test.GroovyPagesTestCase

class DecoratorTagLibTests extends GroovyPagesTestCase {

    def grailsApplication

    void testInstalledClasses() {
        def list = grailsApplication.decoratorClasses*.propertyName
        assert list.contains('abbreviateDecorator')
        assert list.contains('jiraDecorator')
        assert list.contains('asciidoctorDecorator')
        assert list.contains('telephoneDecorator')
        assert list.contains('urlDecorator')
    }

    void testEnabledClasses() {
        def list = grailsApplication.decoratorClasses.findAll { it.enabled }*.propertyName
        assert list.contains('abbreviateDecorator')
        assert list.contains('telephoneDecorator')
        assert list.contains('urlDecorator')
        assert list.contains('asciidoctorDecorator')

        assert !list.contains('jiraDecorator')
    }

    void testAsciidoctor() {
        def result = applyTemplate('<g:decorate include="asciidoctor">The quick brown **fox** jumps over the lazy **dog**.</g:decorate>').trim()
        assert result == "<div class=\"paragraph\">\n<p>The quick brown <strong>fox</strong> jumps over the lazy <strong>dog</strong>.</p>\n</div>"
    }
}
