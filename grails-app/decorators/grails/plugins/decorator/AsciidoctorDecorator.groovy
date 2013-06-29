/*
 * Copyright (c) 2012 Goran Ehrsson.
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

import static org.asciidoctor.Asciidoctor.Factory.create
import org.asciidoctor.Asciidoctor

class AsciidoctorDecorator {

    def enabled = false

    Asciidoctor asciidoctor = create()

    String decorate(String text, Map params) {
        asciidoctor.render(text, params)
    }
}