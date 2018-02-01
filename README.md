# AndroidDataBindingWithRxJava

Data binding requires changes in layout files.  Such layout files starts with a <layout> root tag followed by a <data> element and a view root element.
  
References to the data elements or expressions within the layout are written in the attribute properties using the @{} or @={},

First thing you need to enable data binding is add below entry in gradle.build file

dataBinding {
        enabled = true
    }
    
sample code:

you can refer main_activity.xml

 <data>
        <import type="android.view.View"></import>

        <variable
            name="user"
            type="com.shan.databindingrxjava.viewmodel.UserViewModel" />
    </data>


...........*....

                  <android.support.v7.widget.RecyclerView
                    android:id="@+id/list_user"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="@android:color/white"
                    android:scrollbars="vertical"
                    android:visibility="@{user.userRecycler}"
                    app:layout_behavior="@string/appbar_scrolling_view_behavior"
                    tools:listitem="@layout/list_item" />
                    
 
                    
                    

