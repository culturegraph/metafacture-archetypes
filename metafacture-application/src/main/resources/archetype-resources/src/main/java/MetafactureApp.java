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

import org.culturegraph.mf.stream.converter.LineReader;
import org.culturegraph.mf.stream.sink.ObjectWriter;
import org.culturegraph.mf.stream.source.ResourceOpener;

/**
 * An example application which builds a small flow to read a text
 * resource and print its content on standard out.
 *
 * @author Christoph Böhme
 *
 */
public final class MetafactureApp {

	private MetafactureApp() {
		// No instances allowed
	}

	public static void main(final String[] args) {
		final ResourceOpener opener = new ResourceOpener();
		final LineReader reader = new LineReader();
		final ObjectWriter<String> writer = new ObjectWriter<String>("stdout");

		opener.setReceiver(reader)
				.setReceiver(writer);

		opener.process("test-data.txt");
		opener.closeStream();
	}

}