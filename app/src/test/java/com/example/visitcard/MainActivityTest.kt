package com.example.visitcard

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private val composeTest = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun `Ensure WHEN the MainActivity is Called the root screen is visible`() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity: MainActivity ->
                activity.setContent {
                    composeTest.onRoot().assertIsDisplayed()
                }
            }
        }
    }

    @Test
    fun `Ensure the PresentationCard init With Value`() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { Activity: MainActivity ->
                Activity.setContent {
                    composeTest.onNodeWithTag("Job").assertIsDisplayed()
                        .assertTextContains("Android Developer in Build Process")
                }

            }
        }
    }

    @Test
    fun `Ensure the Information cards changed values`() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { Activity: MainActivity ->
                Activity.setContent {
                    composeTest.onNodeWithTag("Contact Informations").assertIsDisplayed()
                    InformationsCard(
                        icon = painterResource(id = R.drawable.ic_baseline_email_24),
                        information = "Teste",
                        modifier = Modifier.padding(all = 15.dp)
                    )
                    Activity.recreate()
                    composeTest.onNodeWithTag("Contact Informations").assertTextContains("Teste")

                }

            }
        }
    }


}