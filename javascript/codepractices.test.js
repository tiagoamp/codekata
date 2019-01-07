const practices = require('./codepractices.js');

test('Hello Test World', () => {
    const result = practices.hello();
    expect('hello').toEqual(result);
});