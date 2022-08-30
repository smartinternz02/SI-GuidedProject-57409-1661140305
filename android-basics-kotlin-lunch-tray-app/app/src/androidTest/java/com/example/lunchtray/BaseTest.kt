/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import android.os.Parcel
import android.os.Parcelable
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

open class BaseTest() : Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    fun fullOrderFlow() {
        // Launch the main activity
        launchActivity<MainActivity>()
        // Start order
        onView(withId(R.id.start_order_btn)).perform(click())
        // Select entree item
        onView(withId(R.id.cauliflower)).perform(click())
        // Move to next fragment
        onView(withId(R.id.next_button)).perform(click())
        // Select side item
        onView(withId(R.id.salad)).perform(click())
        // Move to next fragment
        onView(withId(R.id.next_button)).perform(click())
        // Select accompaniment item
        onView(withId(R.id.bread)).perform(click())
        // Move to next fragment
        onView(withId(R.id.next_button)).perform(click())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseTest> {
        override fun createFromParcel(parcel: Parcel): BaseTest {
            return BaseTest(parcel)
        }

        override fun newArray(size: Int): Array<BaseTest?> {
            return arrayOfNulls(size)
        }
    }
}
