/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.mlkit.md.productsearch

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.firebase.database.FirebaseDatabase
import com.google.mlkit.md.ObjDetected

import com.google.mlkit.md.R
import com.google.mlkit.md.productsearch.ProductAdapter.ProductViewHolder



/** Presents the list of product items from cloud product search.  */
class ProductAdapter(private val productList: List<Product>) : Adapter<ProductViewHolder>() {

    class ProductViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {


        private val titleView: TextView = view.findViewById(R.id.product_title)
        private val subtitleView: TextView = view.findViewById(R.id.product_subtitle)
        private val imageSize: Int = view.resources.getDimensionPixelOffset(R.dimen.product_item_image_size)
        private val buttonSave: Button = view.findViewById(R.id.buttonSave)


        fun bindProduct(product: Product) {

            titleView.text = product.title
            subtitleView.text = product.subtitle
            buttonSave.setOnClickListener{
                showName()
            }
        }

    private fun showName(){
        val name = titleView.text.toString().trim()
        val ref = FirebaseDatabase.getInstance().getReference("Detected")
        val objId =ref.push().key.toString()

        val obj =ObjDetected(objId,name)
        ref.child(objId).setValue(obj).addOnCompleteListener{}

    }
        companion object {
            fun create(parent: ViewGroup) =
                ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder.create(parent)

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}
