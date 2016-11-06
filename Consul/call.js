"use strict";
//
// Usage: frida -f ./consul -l call.js
//

let real_help = new NativeFunction(DebugSymbol.fromName("real_help").address, "void", []);
let fake_help = new NativeFunction(DebugSymbol.fromName("fake_help").address, "void", []);
let dont_call_me = new NativeFunction(DebugSymbol.fromName("dont_call_me").address, "void", []);
let help = new NativeFunction(DebugSymbol.fromName("help").address, "void", []);
let c8 = new NativeFunction(DebugSymbol.fromName("c8").address, "void", []);

let m0 = ptr("0x601368");
Memory.writeU32(m0, 0x400520); // 0x400520 = malloc@plt

fake_help();
real_help();
dont_call_me();
help();

// fake_help -> The end is forever. But after that, you're good to go. \n Poor Bernie.
// real_help -> Leonardo De Pisa? Who's that–The next president? \n Poor Bernie.
// help -> We didn't deserve Bernie.׼�st9 \n Poor Bernie.
//        "We didn't deserve Bernie.\xd7\xbc\xef\xbf\xbdst9"
// dont_call_me -> hi.�	\n Poor Bernie
//                "hi.\xef\xbf\xbd"
// c8 -> /5*0D@;2=.(27(+.;72.�F
//      "/5*0D@;2=.(27(+.;72.\xef\xbf\xbdF"

