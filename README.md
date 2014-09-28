PreferenceVObjectFile
=====================

比较使用Preference和对象存储文件的速度

第一次存取时（初始化SharedPreference）时SharedPreference慢于ObjectFile，但在其它时候都胜于ObjectFile
所以在进行简单对象存储时选择SharedPreference
ContextImpl对SharedPreference做了优化，使用Map缓存，所以二次更快

由于多了xml节点，SharedPreference文件比ObjectFile略大

![image](https://github.com/AltasT/PreferenceVObjectFile/blob/master/PreferenceVObjectFile/Screenshots/Screenshosts.png)
