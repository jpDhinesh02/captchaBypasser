Captcha ByPasser

* Bypassing catcha while automation using chrome extension "Buster: Captcha Solver for Humans".
* To add the extension with lauching driver
	# Steps to add extension with driver:
		> Go to manage extension google page - chrome://extensions/
		> Change the toogle to Developer mode locate on right corner of the page
		> Find the extension and click Details
		> Find the extension ID
		> Click Pack extension
		> Click Browse of Root direcyory field and navigate to "C:\Users\<Your Username>\AppData\Local\Google\Chrome\User Data\Default\Extensions\<Extension ID>\<Version>" 
			*Note Replace username, extionsion ID and version folder
		> After complete, Click Pack Extension
		> Now, Create crx file in the path "C:\Users\<Your Username>\AppData\Local\Google\Chrome\User Data\Default\Extensions\<Extension ID>"
* After create Crx file now add the crx file with driver using ChromeOptions arguments
	# Code to launch driver with extension
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		String captchaSolver = System.getProperty("user.dir") + "//captchaSolver//3.1.0_0.crx";
		options.addExtensions(new File(captchaSolver));
		WebDriver driver = new ChromeDriver(options);
