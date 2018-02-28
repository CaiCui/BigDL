/*
 * Copyright 2016 The BigDL Authors.
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

package com.intel.analytics.bigdl.nn.tf

import com.intel.analytics.bigdl.nn.abstractnn.DataFormat
import com.intel.analytics.bigdl.tensor.Tensor
import com.intel.analytics.bigdl.utils.T
import com.intel.analytics.bigdl.utils.serializer.ModuleSerializationTest

import scala.util.Random

class Conv3DBackpropInputSerialTest extends ModuleSerializationTest {
  override def test(): Unit = {
    val module = Conv3DBackpropInput[Float](1, 2, 3, 0, 0, 0, DataFormat.NHWC)
    val input = Tensor[Float](4, 20, 30, 40, 3).rand()
    val filter = Tensor[Float](2, 3, 4, 3, 4).rand()
    val outputBackprop = Tensor[Float](4, 19, 14, 13, 4).rand()

    runSerializationTest(module, T(input, filter, outputBackprop))
  }
}