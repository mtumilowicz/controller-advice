# controller-advice
Exploring basic features of exception handling in Spring (`@ControllerAdvice`).

# preface
Before `Spring 3.2`, the main approach to handling exceptions in a 
`Spring MVC` application was `@ExceptionHandler` annotation.

After `3.2` we now have the new `@ControllerAdvice` annotation to address 
the limitations of the previous one.

* `@ExceptionHandler`
    ```
    public class FooController{
         
        //...
        @ExceptionHandler({ CustomException1.class, CustomException2.class })
        public void handleException() {
            //
        }
    }
    ```
    **drawback**: is active only for that particular Controller.
    
# definition
A controller advice allows you to use similar exception handling 
techniques to `@ExceptionHandler` but apply them across the whole application, 
not just to an individual controller. You can think of them as an annotation 
driven interceptor.

# manual
Any class annotated with `@ControllerAdvice` becomes a controller-advice, then
we have to write method that will handle specific exception:

```
@ResponseStatus(code = HttpStatus.NOT_FOUND)
@ExceptionHandler(EntityNotFoundException.class)
@ResponseBody
ApplicationExceptionAsJSON entityNotFoundException(@NonNull HttpServletRequest request, 
                                                          @NonNull EntityNotFoundException ex) {
    Preconditions.checkArgument(nonNull(request.getRequestURI()));
    Preconditions.checkArgument(nonNull(ex.getLocalizedMessage()));
    
    return ApplicationExceptionAsJSON.builder()
            .url(request.getRequestURI())
            .message(ex.getLocalizedMessage())
            .build();
}
```

# project description
* `EntityNotFoundExceptionInterceptor` is `@ControllerAdvice`