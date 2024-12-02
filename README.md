Android Project 5 - BitSleep
Submitted by: Querida Emmanuel

BitSleep is a health metrics app that allows users to track sleep hours daily, helping them monitor and improve their sleeping habits.

Time spent: 7 hours spent in total.

Required Features
The following required functionality is completed:

 At least one health metric is tracked (based on user input)
Chosen metric(s): Hours Slept
 There is a "create entry" UI that prompts users to make their daily entry
 New entries are saved in a database and then updated in the RecyclerView
 On application restart, previously entered entries are preserved (i.e., are persistent)
The following optional features are implemented:

 Create a UI for tracking averages and trends in metrics
 Improve and customize the user interface through styling and coloring
 Implement orientation responsivity
 Add a daily photo feature
The following additional features are implemented:

 (List any custom features you’ve added for extra credit!)
Video Walkthrough
<div>
    <a href="https://www.loom.com/share/488f488ef1db4e26b5006a4f9280330f">
    </a>
    <a href="https://www.loom.com/share/488f488ef1db4e26b5006a4f9280330f">
      <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/488f488ef1db4e26b5006a4f9280330f-012d6a6869cb3a4d-full-play.gif">
    </a>
  </div>



GIF created with:

ScreenToGif for Windows

Notes
Challenges Encountered:
Implementing Room Database: Setting up the Room DAO and database schema was tricky at first. The initial builds failed due to misconfigured dependencies.
Lifecycle Management: Integrating coroutines with lifecycleScope required extra troubleshooting and understanding of Android’s lifecycle handling.
UI Enhancements: While the basic functionality is in place, the styling and UI improvements could use more work to make the app visually engaging.
License
Copyright 2024 Querida Emmanuel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
