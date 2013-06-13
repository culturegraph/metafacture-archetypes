#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 *  Copyright ${licenseYear} ${licenseAuthor}
 *
 *  Licensed under the Apache License, Version 2.0 the "License";
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ${package};

import org.culturegraph.mf.framework.DefaultObjectPipe;
import org.culturegraph.mf.framework.ObjectReceiver;
import org.culturegraph.mf.framework.annotations.Description;
import org.culturegraph.mf.framework.annotations.In;
import org.culturegraph.mf.framework.annotations.Out;

/**
 * A simple object pipe which returns the string representation of every 
 * object it receives prepended with a Hello World message.
 * 
 * @author Christoph Böhme
 * 
 */
@Description("A simple object pipe which returns the string representation of " +
		"every object it receives prepended with a Hello World message")
@In(Object.class)
@Out(String.class)
public final class HelloWorldPipe<T> extends DefaultObjectPipe<T, ObjectReceiver<String>> {
	
	public static final String WELCOME_TEXT = "Hello World: ";
	
	@Override
	public void process(T obj) {
		getReceiver().process(WELCOME_TEXT + obj.toString());
	}

}
