import frida
import sys

#
# This code is not working on my device, feel free to reach me on Twitter @fvrmatteo
# if you know a possible solution to the problem.
#

PROCESS_NAME = 'en.cold.jewel.th.lines'

jscode = """
if (Java.available) {
	Java.perform(function() {
		var AdfdI9FaQBbbW3Hgur24m6n0 = Java.use("infiltration.AdfdI9FaQBbbW3Hgur24m6n0");
		AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX.overload('java.lang.String', 'java.security.PrivateKey').implementation = function(x, y) {
			var ret_value = this.vvgQM33AjqPJZjX(x, y);
			send("SERVER: " + ret_value);
			return ret_value;
		};
		AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX.overload('java.lang.String', 'java.security.PublicKey').implementation = function(x, y) {
			var ret_value = this.vvgQM33AjqPJZjX(x, y);
			send("CLIENT: " + x);
			return ret_value;
		};
	});
} else {
	send("Java not available in this process");
}
"""

# define callback function to receive and output messages received from server
def on_message(message, data):
   print(message)
# get connect to frida server through usb and attach to process
session = frida.get_usb_device().attach(PROCESS_NAME)
# create script using script file opened above
script = session.create_script(jscode)
# setup callback using function defined above
script.on('message', on_message)
# load script into the process
script.load()
# read from stdin to keep script running
sys.stdin.read()
