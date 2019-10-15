
var app = angular.module("embibeApp", []);
app.controller("appCtrl", function($scope,$window) {

    $scope.allAnswers = '';
    $scope.allAnsArr = [];
    $scope.answersHash = {};
    $scope.isJEEAdv = true;
    var answerPage = false;

    $window.setActive = function(active) {
        document.title = active;
    }

    $window.setData = function(json)
    {
        $window.scrollTo(0,0);
        $scope.question = json;
        $scope.showCorrect = false;
        answerPage = false;
        if($scope.question.category == "Matrix")
        {
          var f_ans = $scope.question.answers[0].body;
          $scope.answer_options = eval(f_ans.split(";;")[0]);
          $scope.matrix_header_top = $scope.answer_options[1];
          $scope.matrix_header_left = $scope.answer_options[0];
        }

         setTimeout(function () {
         MathJax.Hub.Queue(["Typeset", MathJax.Hub]);
         });

        $scope.allAnsArr = [];
        $("#integer_input").val('');
        $("#subjective_input").val('');
        $scope.allAnswers = '';
        $scope.answersHash = {};

        if(!$scope.$$phase)
        {
          $scope.$apply();
        }

        if(window.PracticeAndroidAPI.getAnswer())
        {
          $scope.updateAnswers(window.PracticeAndroidAPI.getAnswer());
        }
        else
        {
          $window.clearSelections();
        }

      if(!$scope.$$phase)
      {
        $scope.$apply();
      }
    }

    $window.submitSelection = function()
    {
      var selectedAnswer = window.PracticeAndroidAPI.getAnswer();
      var correctAnswer = window.PracticeAndroidAPI.getCorrectAnswer();
      answerPage = true;

      if($scope.question.category == "Matrix")
      {
        var f_ans;
        for (var i = 0; i < $scope.question.answers.length; i++) {
          if($scope.question.answers[i].code === selectedAnswer){
            f_ans = $scope.question.answers[i].body;
            break;
          }else if ($scope.question.answers[i].correct == true) {
              f_ans = $scope.question.answers[i].body;
              break;
            }
        }
        selectedAnswer = selectedAnswer.split(";;")[1];
      }

       if($scope.question.category != "Integer" && $scope.question.category != "Subjective Numerical" &&
        $scope.question.category != "Matrix")
       {

         if($scope.question.category == 'Multiple Choice' || $scope.question.category == 'Linked Comprehension Multiple Choice'){
           for(var i=0;i<$scope.question['answers'].length;i++)
           {
              if(correctAnswer.indexOf($scope.question.answers[i].code) > -1) {
                $scope.question.answers[i].correct = true;
              }
              else {
                $scope.question.answers[i].correct = false;
                if(selectedAnswer.indexOf($scope.question.answers[i].code) > -1) {
                  $scope.question.answers[i].wrong = true;
                }
                else {
                  $scope.question.answers[i].wrong = false;
                }
              }
           }
         }else{
           for(var i=0;i<$scope.question.answers.length;i++) {

               if($scope.question.answers[i].code === correctAnswer) {
                   $scope.question.answers[i].correct = true;
               }else{
                 if($scope.question.answers[i].code === selectedAnswer){
                   $scope.question.answers[i].wrong = true;
                 }else{
                   $scope.question.answers[i].wrong = false;
                 }
                 $scope.question.answers[i].correct = false;
               }
           }
         }
       }

       else if($scope.question.category == "Integer" || $scope.question.category == "Subjective Numerical")
       {
          if(selectedAnswer)
          {
            if($scope.question.category == "Integer" ) {
                      $scope.integer_input = Number(selectedAnswer);
                      if(selectedAnswer == $scope.question['answers'][0].body)
                      {
                          $scope.question['answers'][0]['selected'] = true;
                          $scope.question['answers'][0]['correct'] = true;
                          $scope.showCorrect = false;
                      }
                      else
                      {
                          $scope.question['answers'][0]['selected'] = true;
                          $scope.question['answers'][0]['correct'] = false;
                          $scope.showCorrect = true;
                      }
            } else {
                      $scope.integer_input = Number(selectedAnswer);

                      var correctAnswer = $scope.question['answers'][0].body;
                      var selectedAnswerFloat = parseFloat(selectedAnswer);
                      var correctAnswerFloat = parseFloat(correctAnswer);
                      var tokens =correctAnswer.split(".");

                      if(tokens.length >1 && tokens[1].length> 2){
                          correctAnswerFloat =parseFloat(correctAnswerFloat.toFixed(2));
                          var correctAnswerFloatDelta = correctAnswerFloat +parseFloat( 0.01);
                          if (selectedAnswerFloat >= correctAnswerFloat && selectedAnswerFloat <= correctAnswerFloatDelta) {
                            $scope.showCorrect = false;
                          }
                      } else if(selectedAnswerFloat == correctAnswerFloat){
                          $scope.question['answers'][0]['selected'] = true;
                          $scope.question['answers'][0]['correct'] = true;
                          $scope.showCorrect = false;
                      } else {
                          $scope.question['answers'][0]['selected'] = true;
                          $scope.question['answers'][0]['correct'] = false;
                          $scope.showCorrect = true;
                      }
            }
          }
          else
          {
            $scope.integer_input = '';
            $scope.question['answers'][0]['selected'] = false;
            $scope.showCorrect = false;
          }
       }
       else if($scope.question.category == "Matrix")
       {
          if(selectedAnswer)
          {
            if(correctAnswer.indexOf(selectedAnswer) > -1)
            {
              $scope.showIncorrectMatrix = false;
            }
            else
            {
              $scope.showIncorrectMatrix = true;
              $scope.matrixSelectedAns = selectedAnswer;
            }
          }
          else
          {
              $scope.showIncorrectMatrix = false;
          }
       }

      $scope.showData = true;
      $scope.$apply();
    }

    $scope.selectAnswers = function(answer)
    {
      if(answerPage == false){
        if($scope.question.category !== 'Multiple Choice' && $scope.question.category !== 'Integer'
          && $scope.question.category !== 'Subjective Numerical' && $scope.question.category !== 'Linked Comprehension Multiple Choice' ) {
          $window.clearSelections();
          answer.selected = true;
          window.PracticeAndroidAPI.selectAnswer(answer.code);
          window.PracticeAndroidAPI.setAnswer(answer.code);
        }
        else {
          answer.selected = !answer.selected;
          if($scope.question.category == 'Multiple Choice' || $scope.question.category == 'Linked Comprehension Multiple Choice')
          {
            if(answer.selected)
            {
              window.PracticeAndroidAPI.selectAnswer(answer.code);
              $scope.allAnsArr.push(answer.code);
            }
            else
            {
                window.PracticeAndroidAPI.deselectAnswer(answer.code);
                if((indx = $scope.allAnsArr.indexOf(answer.code)) > -1){
                  $scope.allAnsArr.splice(indx, 1);
                }
            }

          }
          window.PracticeAndroidAPI.setAnswer($scope.allAnsArr.join(","));
        }
      }
    }

    $scope.setIntegerValue = function()
    {
      if(answerPage == false){
        window.PracticeAndroidAPI.inputAnswer($("#integer_input").val());
        window.PracticeAndroidAPI.setAnswer($("#integer_input").val());
      }
    }

    $scope.setSubjectiveNumericalValue = function()
    {
      if(answerPage == false){
        window.PracticeAndroidAPI.inputAnswer($("#subjective_input").val());
        window.PracticeAndroidAPI.setAnswer($("#subjective_input").val());
      }
    }

    $scope.updateAnswers = function(answers)
    {
      this.answersSelected = answers;
      if($scope.question.category !== 'Integer'
         && $scope.question.category !== 'Subjective Numerical' && $scope.question.category !== 'Matrix')
      {
        // $window.clearSelections();
        angular.forEach($scope.question.answers, function(answer)
        { if(this.answersSelected && this.answersSelected.indexOf(answer.code) > -1) { answer.selected = true; $scope.allAnsArr.push(answer.code); } },this);
      }
      else if($scope.question.category == 'Integer') {
        $("#integer_input").val(answers);
      } else if($scope.question.category == 'Subjective Numerical') {
        $("#subjective_input").val(answers);
      }
    }

    $scope.updateHashMap = function(answer) {
        $scope.answersHash = [];
        tokens = answer.split(";");
        var i;
        var token;
        for (i = 0; i < tokens.length; i++) {
          token = tokens[i];
          if(token || 0 !== token.length) {
              var keyValueTokens = token.split('-');
              var k = keyValueTokens[0];
              if(keyValueTokens[1].length > 0) {
                  var v = keyValueTokens[1].split(',');
                  if(!$scope.answersHash[k]) {
                    $scope.answersHash[k] = [];
                  }
                  for (j = 0; j < v.length; j++) {
                    $scope.answersHash[k].push(v[j]);
                    $scope.answersHash[k].sort();
                  }
              }
            }
        }
    }

    $scope.matrixAnswerChange = function(matrix, answer) {
      if(answerPage == false){
        var dimensions = answer.body.split(";;")[0];
        var existingAnswers = window.PracticeAndroidAPI.getAnswer();
        if (existingAnswers !== undefined && existingAnswers !== null && existingAnswers.length > 0) {
            var existingAnswers = existingAnswers.split(";;")[1];
            $scope.updateHashMap(existingAnswers);
        }

        var mat = matrix.split("-");
        var key = mat[0];
        var value = mat[1];
        var type = "select";
        if (answer["count"] == undefined) answer["count"] = 0;
        if (!answer[key]) answer[key] = {};
        if (answer[key][value] && answer[key][value] == true) {
            answer[key][value] = false
            var type = "deselect";
            answer["count"] = answer["count"] - 1;
            ($scope.question.question_code+"-"+key+"-"+value).isChecked = false;
            window.PracticeAndroidAPI.deselectAnswer($scope.question.question_code+"-"+matrix);
        } else {
            answer[key][value] = true;
            ($scope.question.question_code+"-"+key+"-"+value).isChecked = true;
            window.PracticeAndroidAPI.selectAnswer($scope.question.question_code+"-"+matrix);
            answer["count"] = answer["count"] + 1;
        }
        answer.selected = !!answer["count"];

        if(!$scope.answersHash[key]){
            $scope.answersHash[key] = [];
        }

        var answerArr = $scope.answersHash[key];
        if((index = answerArr.indexOf(value)) > -1) {
            answerArr.splice(index, 1);
        } else {
            $scope.answersHash[key].push(value);
            $scope.answersHash[key].sort();
        }

        $scope.allAnswers = "";
        for (var key in $scope.answersHash) {
            var options = $scope.answersHash[key];
            $scope.allAnswers += key + '-' + options.join(",") + ';';
        }
        if ($scope.allAnswers && $scope.allAnswers.length > 0) {
            window.PracticeAndroidAPI.setAnswer(dimensions + ";;" + $scope.allAnswers);
        } else {
            window.PracticeAndroidAPI.setAnswer("");
        }
      }
    }

    $scope.isMatrixAnswerChecked = function(header,header2)
    {
        if($scope.question.category == "Matrix")
        {
            var qcode = $scope.question.question_code;
            var corrAns = window.PracticeAndroidAPI.getAnswer();
            if (answerPage){
              corrAns = window.PracticeAndroidAPI.getCorrectAnswer();
            }
            if(corrAns)
            {
              var corrAns = corrAns.split(";;")[1];
              var corrAnsArr = corrAns.split(";");
              corrAnsArr.pop();
              var correctAnswers = [];
              for (var i in corrAnsArr)
              {
                  var key_val = corrAnsArr[i].split("-")
                  var key = key_val[0];
                  var value = key_val[1];
                  var valArr = value.split(",");
                  for(var value in valArr)
                  {
                    correctAnswers.push(qcode+'-'+key+ "-" +valArr[value]);
                  }
              }
              if(correctAnswers.indexOf(qcode+'-'+header+"-"+header2) > -1)
              {
                return true;
              }
              return false;
            }
            else return false;
        }
        else
        {
          return false;
        }
    }

    $scope.MatrixAnswerSelected = function(header,header2)
    {
        if($scope.question.category == "Matrix")
        {
            var qcode = $scope.question.question_code;
            var corrAns = window.PracticeAndroidAPI.getAnswer();
            if(corrAns)
            {
              var corrAns = corrAns.split(";;")[1];
              var corrAnsArr = corrAns.split(";");
              corrAnsArr.pop();
              var correctAnswers = [];
              for (var i in corrAnsArr)
              {
                  var key_val = corrAnsArr[i].split("-")
                  var key = key_val[0];
                  var value = key_val[1];
                  var valArr = value.split(",");
                  for(var value in valArr)
                  {
                    correctAnswers.push(qcode+'-'+key+ "-" +valArr[value]);
                  }
              }
              if(correctAnswers.indexOf(qcode+'-'+header+"-"+header2) > -1)
              {
                return true;
              }
              return false;
            }
            else return false;
        }
        else
        {
          return false;
        }
    }

    $window.clearSelections = function()
    {
      if($scope.question.category == 'Integer' || $scope.question.category == 'Subjective Numerical')
      {
        $("#integer_input").val('');
        $("#subjective_input").val('');
      }
      else if($scope.question.category == 'Matrix')
      {
        $("."+$scope.question.question_code+"-seq").attr('checked', false);
      }
      else
      {
        angular.forEach($scope.question.answers, function(answer)
        { answer.selected = false;});
      }
      // $(".answer_panel").removeClass("selected_answer");
      if(!$scope.$$phase)
      {
        $scope.$apply();
      }
    }


    $scope.extractParagraphFromComprehension = function(string)
    {
      var splittedArray = string.split('<br />\r\n<br />');
      if(splittedArray.length > 1){
        splittedArray.pop();
      }
      return splittedArray.join('<br />\r\n<br />');
    }

    $scope.extractQuestionForLinkComprehension = function(string){
      var splittedArray = string.split('<br />\r\n<br />');
      if(splittedArray.length == 1){
        return '';
      }
      if(1){
        return "<strong>Question :</strong>" +  splittedArray[splittedArray.length-1];
      }
      else{
        return splittedArray[splittedArray.length-1]
      }
    }
})

 app.directive("mathjaxBind", function() {
        return {
            restrict: "A",
            scope: {
                text: "@mathjaxBind"
            },
            controller: ["$scope", "$element", "$attrs", function($scope, $element, $attrs) {
                $scope.$watch('text', function(value) {
                    var $script = angular.element("<script type='math/tex; mode=" + ($attrs.mathjaxMode == undefined ? "inline" : $attrs.mathjaxMode) + "'>")
                        .html(value == undefined ? "" : value);
                    $element.html("");
                    $element.append($script);
                    MathJax.Hub.Queue(["Reprocess", MathJax.Hub, $element[0]]);
                });
            }]

        };
    })

app.directive('dynamicData', function($compile) {
    return {
        restrict: 'A',
        replace: true,
        link: function(scope, ele, attrs) {
              scope.$watch(attrs.dynamicData,
                function(html) {
                    if(html != undefined)
                    {
                     html = html.replace(/\{/g, " \{");
                     html = html.replace(/\{/g, " \{");
                     html = html.replace(/\{\{/g, " \{ \{");
                     html = html.replace(/\}\}/g, " \} \}");
                     html = html.replace(/\$\$([^$]+)\$\$/g, "<span mathjax-bind=\"$1\"></span>");
                     html = html.replace(/\$([^$]+)\$/g, "<span mathjax-bind=\"$1\"></span>");
                     html = html.replace(/\{\{/g, " \{ \{");
                     // html = html.replace(/\�*/g, "");
                     ele.html(html);
                     $compile(ele.contents())(scope);
                    }
                });
        }
    };
});


app.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {

                if (text) {
                    var transformedInput = text.split('')[0].replace(/[^0-9]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            if(attr.numbersOnly == 'Integer')
             ngModelCtrl.$parsers.push(fromUser);
        }
    };
});
