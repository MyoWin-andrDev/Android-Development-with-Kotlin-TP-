Kotlin provides **scope functions** to execute a block of code in the context of an object. They help improve code readability and conciseness. The five main scope functions are:

1. **`let`**
    - Used when you need to operate on a nullable object or transform its value.
    - Returns the result of the lambda expression.
    - `this` is replaced by `it`.
    - **Example:**
      ```kotlin
      val name: String? = "Kotlin"
      name?.let {
          println(it.uppercase())  // Output: KOTLIN
      }
      ```

2. **`run`**
    - Used when you need to initialize objects or execute a block of code and return a result.
    - Returns the result of the lambda.
    - `this` is used inside the lambda.
    - **Example:**
      ```kotlin
      val message = "Hello".run {
          this + " Kotlin"
      }
      println(message) // Output: Hello Kotlin
      ```

3. **`with`**
    - Used to operate on an object without returning the object itself.
    - Not an extension function; calls are made in function style.
    - Returns the lambda result.
    - **Example:**
      ```kotlin
      val person = Person("John", 25)
      with(person) {
          println("Name: $name, Age: $age")
      }
      ```

4. **`apply`**
    - Used to configure an object and return the object itself.
    - Returns `this`.
    - `this` is used inside the lambda.
    - **Example:**
      ```kotlin
      val person = Person().apply {
          name = "Alice"
          age = 30
      }
      ```

5. **`also`**
    - Used for additional operations (logging, debugging) without modifying the object.
    - Returns `this`.
    - `this` is replaced by `it`.
    - **Example:**
      ```kotlin
      val numbers = mutableListOf(1, 2, 3).also {
          println("Initial List: $it") // Output: Initial List: [1, 2, 3]
      }
      ```

### **Summary Table**

| Function  | Returns       | `this` / `it`  | Use case |
|-----------|--------------|---------------|----------|
| `let`     | Lambda result | `it`          | Safe calls, transformations |
| `run`     | Lambda result | `this`        | Object initialization, chaining operations |
| `with`    | Lambda result | `this`        | Operate on an object without returning it |
| `apply`   | The object    | `this`        | Object configuration |
| `also`    | The object    | `it`          | Additional operations (logging, debugging) |

