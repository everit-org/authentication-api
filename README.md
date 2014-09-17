authentication-context-api
==========================

API for executing authenticated processes and query the authenticated user of 
the current thread.

#Interfaces
 - [AuthenticationPropagator][3]: executes the authenticated process in the 
 name of the authenticated Resource ID
 - [AuthenticationContext][4]: we can query the Resource ID of the actual 
 Thread or the configured Default Resource ID (aka Guest Resource ID)

#How to use the Authentication Context API?
Usage examples are availbe [here][5].

#Concept
Full authentication concept is available on blog post [Everit Authentication][2].

#Implementation
Available implementation is [authentication-context-ri][1].

[1]: https://github.com/everit-org/authentication-context-ri
[2]: http://everitorg.wordpress.com/2014/07/31/everit-authentication/
[3]: http://attilakissit.wordpress.com/2014/07/09/everit-authentication/#authentication_propagator
[4]: http://attilakissit.wordpress.com/2014/07/09/everit-authentication/#authentication_context
[5]: http://attilakissit.wordpress.com/2014/07/09/everit-authentication/#using_ap_ac
