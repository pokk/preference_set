# preference_set
Pychram or Android Studio Preference Setting


## Android Studio

#### In the MAC

Copy or overwrite the __fileTemplate__ to ~/Library/Preferences/AndroidStudio{version}/
<br>
You can find the code template were added.

#### Change the key map name

You also can change the key map preference from ~/Library/Preferences/AndroidStudio{version}/keymaps/{your key map}.xml

Open the xml file. The first line should be as below.

```xml
<keymap version="1" name="{YOUR KEY MAP NAME}}" parent="$default">
```

Also if you want to set the to the default when opening the Android Studio, you can modify the file ~/Library/Preferences/AndroidStudio{version}/options/kepmap.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<application>
  <component name="KeymapManager">
    <active_keymap name="{YOUR DEFAULT KEY MAP NAME}" />
  </component>
</application>
```
