package com.akshayholla.keddit

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertTrue

@RunWith(JUnitPlatform::class)
class KotlinSpekTest: Spek({
    given("Hello") {
        it("should add") {
            assertTrue(1 == 1)
        }
    }
})