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

import static org.mockito.Mockito.inOrder;

import org.culturegraph.mf.framework.ObjectReceiver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests for {@link HelloWorldPipe}.
 * 
 * @author Christoph Böhme
 * 
 */
public final class HelloWorldPipeTest {

	private static final String[] TEST_DATA = { "Input1", "Input2" };
	
	private HelloWorldPipe<String> helloWorldPipe;
	
	@Mock
	private ObjectReceiver<String> receiver;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		helloWorldPipe = new HelloWorldPipe<String>();
		helloWorldPipe.setReceiver(receiver);
	}
	
	@After
	public void cleanup() {
		helloWorldPipe.closeStream();
	}
	
	@Test
	public void testShouldReturnPrefixedStringRepresentationOfObjects() {
		helloWorldPipe.process(TEST_DATA[0]);
		helloWorldPipe.process(TEST_DATA[1]);
		
		final InOrder ordered = inOrder(receiver);
		ordered.verify(receiver).process(HelloWorldPipe.WELCOME_TEXT + TEST_DATA[0]);
		ordered.verify(receiver).process(HelloWorldPipe.WELCOME_TEXT + TEST_DATA[1]);
	}
	
}
