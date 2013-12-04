ForceOverflowMenu
=======

On phones with hard menu key like the Samsung Galaxy S3 or 4, the overflow menu does not appear at all.
Some people will think it isn't immediately clear whether there are additional functions you can execute.
Some people will think it is better to have a consistent look across all phones, whether having hard menu key or not.

This implementation is what I learnt from http://developer.android.com/guide/topics/ui/menus.html#PopupMenu
If you searched enough about forcing overflow of the items on the Action Bar, the general answer is:
    DON'T FORCE IT.
   
It disrupts the overall Android feel.

However if it is absolutely necessary you need to force it to appear (maybe your client WANTS it), then this is
how you might implement it.