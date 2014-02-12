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

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ${package}.MetafactureApp;

/**
 * Tests for {@link MetafactureApp}.
 *
 * @author Christoph Böhme
 *
 */
public final class MetafactureAppTest {

	private static final String FILE_CONTENTS = "Welcome to Metafacture!\n\n" +
			"This information was read from a file and written to\n" +
			"standard out using a Metafacture flow.\n\n" +
			"For more information about Metfacture go to\n" +
			"http://culturegraph.github.io/\n\n" +
			"Happy coding!\n";

	private final ByteArrayOutputStream stdout = new ByteArrayOutputStream();
	private final ByteArrayOutputStream stderr = new ByteArrayOutputStream();

	@Before
	public void setupStreams() {
	    System.setOut(new PrintStream(stdout));
	    System.setErr(new PrintStream(stderr));
	}

	@After
	public void cleanupStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void shouldPrintTextFromFile() {
		MetafactureApp.main(null);

		assertEquals(FILE_CONTENTS, stdout.toString());
		assertEquals("", stderr.toString());
	}

}
